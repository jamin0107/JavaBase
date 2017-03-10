package com.jamin.java.designpatterns.builder;

/**
 * Android AlertDialog
 * @author Jamin
 *
 */
public class AlertDialog {

	String title;
	String message;
	
	
	public AlertDialog(){
		
	}
	
	
	public void show(){
		System.out.println("-----------");
		System.out.println("Dialog show");
		System.out.println("Dialog title = " + title);
		System.out.println("Dialog message = " + message);
		System.out.println("-----------");
	}
	
	
	public static class Builder{
		
		String title;
		String message;
		
		
		public Builder(){
			
		}
		
		public Builder setTitle(String title){
			this.title = title;
			return this;
		}
		
		public Builder setMessage(String message){
			this.message = message;
			return this;
		}
		
		
		public AlertDialog create(){
			AlertDialog dialog = new AlertDialog();
			dialog.title = title;
			dialog.message = message;
			System.out.println("Dialog create");
			return dialog;
		}
		
		
		public AlertDialog show(){
			final AlertDialog dialog = create();
			dialog.show();
			return dialog;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new AlertDialog.Builder()
				.setTitle("title---1")
				.setMessage("message---1")
				.create()
				.show();
		
		AlertDialog alertDialog = new AlertDialog.Builder()
		.setTitle("title---2")
		.setMessage("message---2")
		.create();
		alertDialog.show();
	}
}
