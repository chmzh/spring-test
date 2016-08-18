package com.cmz.bean.spel;



import java.util.Map;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Test {
	public static void main(String[] args) {
//		 ExpressionParser parser = new SpelExpressionParser();	 
//		 Expression exp = parser.parseExpression("'Hello World'.concat('!').substring(0,1)"); 
//		 String message = (String) exp.getValue();
//		 System.out.println(message);
		
		
		//================从car中读取name属性
		 Car car = new Car();
		 car.setName("car1");
		 ExpressionParser parser = new SpelExpressionParser();
		 
		//StandardEvaluationContext 有缓存功能
		 EvaluationContext context = new StandardEvaluationContext(car); 
		 context.setVariable("hi", "hello");
		 
		 Expression exp = parser.parseExpression("getName()");
		 
		 String name = (String) exp.getValue(context);
		 
		 //String name = (String)exp.getValue(car);
		 System.out.println(name);
		 //=================================================
//		 EvaluationContext context = new StandardEvaluationContext();
//		 Map<String,String> inventorInfo = (Map<String,String>) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue(context);
//		 for(Map.Entry<String, String> entry : inventorInfo.entrySet()){
//			 System.out.println(entry.getKey()+"=>"+entry.getValue());
//		 }
	}
}
