package com.example.databaseSample.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.databaseSample.entity.student;
import com.example.databaseSample.repository.studentRepository;
import com.example.databaseSample.entity.coursestudent;

@Repository
public class TestDao {
	
	@Autowired
	private EntityManager em;
	
	
	@Autowired
	private studentRepository stdRep;

    
	public List<student> getDetails() {
		
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<student> cq = cb.createQuery(student.class);        
        Root<student> student = cq.from(student.class);
        
        /*
        Predicate authorNamePredicate1 = cb.equal(student.get("firstname"), "saman");
        Predicate authorNamePredicate2 = cb.equal(student.get("lastname"), "silva");
        cq.where(authorNamePredicate1);
        cq.where(authorNamePredicate2);
               
        TypedQuery<student> query = em.createQuery(cq);
        return query.getResultList(); */
        
        /*
        In<String> inClause = cb.in(student.get("firstname"));
        List<String> titles = new ArrayList<>();
        titles.add("saman");
        titles.add("sunil");
        
        
        for (String title : titles) {
            inClause.value(title);
        }
        
        cq.select(student).where(inClause);
        TypedQuery<student> query = em.createQuery(cq);
        return query.getResultList(); */
        
        List<String> titles = new ArrayList<>();
        titles.add("saman");
        titles.add("sunil");
        
       
        
        cq.select(student)
        .where(student.get("firstname")
        .in(titles));
        TypedQuery<student> query = em.createQuery(cq);
        return query.getResultList();
        
	}
	
	
	public void getMultipleTables(String studentName, String schoolName , String courseName) {
		
		
		
        CriteriaBuilder builder =  em.getCriteriaBuilder();
        CriteriaQuery<student> criteria = builder.createQuery(student.class);
        Root<student> medicineRoot = criteria.from(student.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        
		if (studentName != null) {
			predicates.add(builder.equal(medicineRoot.get("firstname"), studentName));
		}		
		if (schoolName != null) {
			predicates.add(builder.equal(medicineRoot.join("highscl").get("schoolname"), schoolName));
		}
		if (courseName != null) {
			predicates.add(builder.equal(medicineRoot.join("studentcources").join("crs").get("coursename"), courseName));
		}
		
		
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		
		List<student> resultList = em.createQuery(criteria).getResultList();
		
		resultList.forEach(s -> System.out.println(s.getFirstname()));
		
		
	}
	
	
	public void getMultipleTables2(String studentName, String schoolName , String courseName) {
		
		
		
        CriteriaBuilder builder =  em.getCriteriaBuilder();
        CriteriaQuery<student> criteria = builder.createQuery(student.class);
        Root<student> medicineRoot = criteria.from(student.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        
		if (studentName != null) {
			predicates.add(builder.equal(medicineRoot.get("firstname"), studentName));
		}		
		if (schoolName != null) {
			predicates.add(builder.equal(medicineRoot.join("highscl").get("schoolname"), schoolName));
		}
		if (courseName != null) {
			predicates.add(builder.equal(medicineRoot.join("studentcources").join("crs").get("coursename"), courseName));
		}
		
		
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		
		List<student> resultList = em.createQuery(criteria).getResultList();
		
		resultList.forEach(s -> System.out.println(s.getFirstname()));
		
		
	}
	
	
	public Page<student> getMultipleTablesPagination(String studentName, Pageable pageable) {
		
	       CriteriaBuilder builder =  em.getCriteriaBuilder();
	        CriteriaQuery<student> criteria = builder.createQuery(student.class);
	        Root<student> medicineRoot = criteria.from(student.class);
	        List<Predicate> predicates = new ArrayList<Predicate>();
	        
			if (studentName != null) {
				predicates.add(builder.equal(medicineRoot.get("firstname"), studentName));
			}
			
			
			criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			
			List<student> resultList = em.createQuery(criteria).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
			
			Page<student> resultCount = new PageImpl<>(resultList, pageable, resultList.size());
			return resultCount;		
		
	}

}
