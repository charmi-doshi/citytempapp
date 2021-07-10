package com.bean;

public class xmlBean {

		private int sId;
		private String sName;
		
		
		
		
	
		public int getsId() {
			return sId;
		}





		public void setsId(int sId) {
			this.sId = sId;
		}





		public String getsName() {
			return sName;
		}





		public void setsName(String sName) {
			this.sName = sName;
		}





		public void display()
		{
			System.out.println("id:" +sId+ " name:" + sName);
		}
}
