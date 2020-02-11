package com.revature.model;

import java.sql.Date;

public class ExpenseModel {

	public int ticket_id;
	public int exp_type;
	public double exp_amount;
	public Date date_sub;
	public Date date_res;
	public String exp_stat;
	public String exp_desc;
	public int exp_userID;
	
	public ExpenseModel() {
		
	}

	public ExpenseModel(int ticket_id, int exp_type, double exp_amount, Date date_sub, Date date_res, String exp_stat, String exp_desc,
			int exp_userID) {
		super();
		this.ticket_id = ticket_id;
		this.exp_type = exp_type;
		this.exp_amount = exp_amount;
		this.date_sub = date_sub;
		this.date_res = date_res;
		this.exp_stat = exp_stat;
		this.exp_desc = exp_desc;
		this.exp_userID = exp_userID;
	}

	public int getExp_type() {
		return exp_type;
	}

	public void setExp_type(int exp_type) {
		this.exp_type = exp_type;
	}

	public double getExp_amount() {
		return exp_amount;
	}

	public void setExp_amount(double exp_amount) {
		this.exp_amount = exp_amount;
	}

	public Date getDate_sub() {
		return date_sub;
	}

	public void setDate_sub(Date date_sub) {
		this.date_sub = date_sub;
	}

	public Date getDate_res() {
		return date_res;
	}

	public void setDate_res(Date date_res) {
		this.date_res = date_res;
	}

	public String getExp_stat() {
		return exp_stat;
	}

	public void setExp_stat(String exp_stat) {
		this.exp_stat = exp_stat;
	}

	public String getExp_desc() {
		return exp_desc;
	}

	public void setExp_desc(String exp_desc) {
		this.exp_desc = exp_desc;
	}

	public int getExp_userID() {
		return exp_userID;
	}

	public void setExp_userID(int exp_userID) {
		this.exp_userID = exp_userID;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	@Override
	public String toString() {
		return "ExpenseModel [ticket_id=" + ticket_id + ", exp_type=" + exp_type + ", exp_amount=" + exp_amount
				+ ", date_sub=" + date_sub + ", date_res=" + date_res + ", exp_stat=" + exp_stat + ", exp_desc="
				+ exp_desc + ", exp_userID=" + exp_userID + "]";
	}


	
	
}
