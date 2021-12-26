package test.pkg.callable;


 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class CallableExample 
{
      public static void main(String[] args) 
      {
          ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
           
          List<Future<Integer>> resultList = new ArrayList<>();
           
          Random random = new Random();
          ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(8,4,2,1));

          for (int i=0; i<4; i++)
          {
              //Integer number = random.nextInt(10);
        	  Integer number = numbers.get(i);
              FactorialCalculator calculator  = new FactorialCalculator(number);
              Future<Integer> result = executor.submit(calculator);
              resultList.add(result);
 
          }
           

       
          for (int i=3; i>-1; i--)
          {
        	  Future<Integer> future = resultList.get(i);
            try
            {
            //System.out.println("in the loop waiting-");
                System.out.println(new Date()+" ------- Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
            } 
            catch (InterruptedException | ExecutionException e) 
            {
                e.printStackTrace();
            }
          }
/*         
         for(Future<Integer> future : resultList)
          {
        	  
                try
                {
                	//System.out.println("in the loop waiting-");
                    System.out.println(new Date()+" ------- Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
                } 
                catch (InterruptedException | ExecutionException e) 
                {
                    e.printStackTrace();
                }
            }
*/          
         
            
            //shut down the executor service now
            executor.shutdown();
      }
}