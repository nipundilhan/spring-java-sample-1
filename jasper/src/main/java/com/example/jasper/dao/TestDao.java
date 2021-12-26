package com.example.jasper.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.jasper.dto.SearchByAreaDateRequest;
import com.example.jasper.wrapper.AreaOrderRespDto;

@Repository
public class TestDao {
	
	
	@PersistenceContext
	private EntityManager manager;
	

	
	public List<AreaOrderRespDto> searchOrders(SearchByAreaDateRequest request) {
		StringBuilder nativeQuery = new StringBuilder();


		nativeQuery.append("SELECT ");
		nativeQuery.append("ordr.orderid AS orderid,");
		nativeQuery.append("cstmr.name AS namecustomer, ");
		nativeQuery.append("cstmr.contactno AS contactno, ");
		nativeQuery.append("cstmr.address AS address, ");
		nativeQuery.append("ordr.amount AS amount, ");
		nativeQuery.append("(ordr.amount*250.00) AS totalprice ");


		
		nativeQuery.append("FROM orderc ordr ");
		nativeQuery.append("JOIN customer cstmr ON cstmr.id = ordr.customerid "); 
		nativeQuery.append("JOIN area ara ON ara.areaid = cstmr.areaid "); 

		List<String> whereConditions = new ArrayList<String>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (request.getAreaid() != 0) {
			
			whereConditions.add("cstmr.areaid = :areid ");
			paramMap.put("areid", request.getAreaid());
			
		}
	
		
		if(request.getDate() != null) {
			whereConditions.add("Date_Format(ordr.orderdate,'%Y-%m-%d') = :orderdate");
			paramMap.put("orderdate", make_date_format(request.getDate()));
			//paramMap.put("getCreatedDateTo", make_date_format(parameter.getCreatedDateTo()));
		}
		
		
		if (!whereConditions.isEmpty()) {
			StringBuilder conditions = new StringBuilder();
			for (int i = 0; i < whereConditions.size(); i++) {
				if(i != 0) {
					conditions.append(" AND ");
					conditions.append(whereConditions.get(i));
				}else {
					conditions.append(whereConditions.get(i));
				}
			}
			nativeQuery.append(" WHERE ");
			nativeQuery.append(conditions.toString());
		}
		nativeQuery.append(" ORDER BY cstmr.id asc ");

		Query query = this.manager.createNativeQuery(nativeQuery.toString() , "AreaOrderRespDtoMapping");

		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		
		return query.getResultList();
	}
	
	
	public String make_date_format(Date date) { 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    formatter.setTimeZone(TimeZone.getTimeZone("Asia/Colombo"));
	    String strDate= formatter.format(date);  
	    System.out.println(strDate);
		return strDate;  
	}

}
