package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancigTests {

	@Test
	public void constructorShouldInstanceFinancingWhenUsingValidParameters() {
		
		double totalAmount = 50000.0;
		double income = 5000.0;
		int months = 20;
		double expectedEntry = 10000.0;
		double expectedQuota = 2000.0;
		
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Assertions.assertEquals(totalAmount, fin.getTotalAmount());
		Assertions.assertEquals(income, fin.getIncome());
		Assertions.assertEquals(months, fin.getMonths());
		Assertions.assertEquals(expectedEntry, fin.entry());
		Assertions.assertEquals(expectedQuota, fin.quota());
	}
	
	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenUsingInvalidParameters() {
		
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			double totalAmount = 100000.0;
			double income = 5000.0;
			int months = 25;
			FinancingFactory.createFinancing(totalAmount, income, months);
		});
	}
	
	@Test
	public void setTotalAmountShouldUpdateTotalAmountWhenUsingValidParameters() {
		
		double totalAmount = 80000.0;
		double income = 10000.0;
		int months = 25;
		double updatedAmount = 100000.0;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		fin.setTotalAmount(updatedAmount);
		
		Assertions.assertEquals(updatedAmount, fin.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenUsingInvalidParameters() {
		
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			double totalAmount = 70000.0;
			double income = 6000.0;
			int months = 20;
			Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
			fin.setTotalAmount(80000.0);
		});
	}
	
	@Test
	public void setIncomeShouldUpdateIncomeWhenUsingValidParameters() {
		
		double totalAmount = 80000.0;
		double income = 6000.0;
		int months = 25;
		double updatedIncome = 5300.0;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		fin.setIncome(updatedIncome);
		
		Assertions.assertEquals(updatedIncome, fin.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenUsingInvalidParameters() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			double totalAmount = 50000.0;
			double income = 8000.0;
			int months = 10;
			Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
			fin.setTotalAmount(51000.0);
		});
	}
	
	@Test
	public void setMonthsShouldUpdateMonthsWhenUsingValidParameters() {
		
		double totalAmount = 80000.0;
		double income = 7000.0;
		int months = 25;
		int updatedMonths = 20;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		fin.setMonths(updatedMonths);
		
		Assertions.assertEquals(updatedMonths, fin.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenUsingInvalidParameters() {
		
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			double totalAmount = 50000.0;
			double income = 8000.0;
			int months = 10;
			Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
			fin.setMonths(8);
		});
	}
	
	@Test
	public void entryShouldCorrectlyCalculateEntryValue() {
		
		double totalAmount = 10000.0;
		double income = 4000.0;
		int months = 10;
		double expectedEntry = 2000.0;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		double entry = fin.entry();
		
		Assertions.assertEquals(expectedEntry, entry);
	}
	
	@Test
	public void quotaShouldCorrectlyCalculateQuotaValue() {
		
		double totalAmount = 10000.0;
		double income = 4000.0;
		int months = 10;
		double expectedQuota = 800.0;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		double quota = fin.quota();
		
		Assertions.assertEquals(expectedQuota, quota);
	}
}
