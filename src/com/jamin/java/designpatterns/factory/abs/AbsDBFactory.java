package com.jamin.java.designpatterns.factory.abs;

import java.lang.reflect.Field;

public class AbsDBFactory implements DBFactory{

	@Override
	public <T extends BaseModel> void insert(Class<T> clz, T t) {
		try {
			BaseModel baseModel = (BaseModel) Class.forName(clz.getName()).newInstance();
			Field[] fileds = clz.getFields();
			StringBuilder sb = new StringBuilder();
			for(Field f : fileds){
				sb.append(f.getType().getSimpleName().toString() + ":" + f.getName() + " = " + f.get(t));
				sb.append("\n");
			}
			System.out.println("INSERT = " + baseModel.getClass().getSimpleName() + "\n" + sb);
		} catch (Exception e) {
			System.out.println("insert Exception");
			e.printStackTrace();
		} 
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}


	

}
