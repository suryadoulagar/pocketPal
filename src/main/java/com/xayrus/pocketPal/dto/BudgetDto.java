package com.xayrus.pocketPal.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BudgetDto {

	private long id;

	@NotBlank
	private String budgetName;

	@NotNull
	@DecimalMin("0.0")
	private BigDecimal amount;

	public BudgetDto() {
	}

	public BudgetDto(long id, String budgetName, BigDecimal amount) {
		this.id = id;
		this.budgetName = budgetName;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBudgetName() {
		return budgetName;
	}

	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
