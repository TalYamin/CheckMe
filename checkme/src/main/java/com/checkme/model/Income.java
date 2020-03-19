package com.checkme.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.checkme.utils.DateConverterUtil;

@Document(collection = "incomes")
public class Income {
	
	@Transient
    public static final String SEQUENCE_NAME = "incomes_sequence";
	
	@Id
	private long incomeId;
	private String clientName;
	private long clientId;
	private String clientPhone;
	private LocalDate operationDate;
	private IncomeType incomeType;
	private double amount;
	
	private String customDate;
	
	
	public Income() {
		
	}
	
	public Income(String clientName, long clientId, String clientPhone, String operationDate,
			IncomeType incomeType, double amount) {
		
		setClientName(clientName);
		setClientId(clientId);
		setClientPhone(clientPhone);
		setOperationDate(DateConverterUtil.convertStringDate(operationDate));
		setIncomeType(incomeType);
		setAmount(amount);
	}

	
	public long getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(long incomeId) {
		this.incomeId = incomeId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public LocalDate getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(LocalDate operationDate) {
		this.operationDate = operationDate;
	}

	public IncomeType getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(IncomeType incomeType) {
		this.incomeType = incomeType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		
		customDate = DateConverterUtil.DateStringFormat(this.operationDate);
		
		return "Income [incomeId=" + incomeId + ", clientName=" + clientName + ", clientId=" + clientId
				+ ", clientPhone=" + clientPhone + ", operationDate=" + customDate + ", incomeType=" + incomeType
				+ ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (clientId ^ (clientId >>> 32));
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((clientPhone == null) ? 0 : clientPhone.hashCode());
		result = prime * result + ((customDate == null) ? 0 : customDate.hashCode());
		result = prime * result + (int) (incomeId ^ (incomeId >>> 32));
		result = prime * result + ((incomeType == null) ? 0 : incomeType.hashCode());
		result = prime * result + ((operationDate == null) ? 0 : operationDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Income other = (Income) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (clientId != other.clientId)
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (clientPhone == null) {
			if (other.clientPhone != null)
				return false;
		} else if (!clientPhone.equals(other.clientPhone))
			return false;
		if (customDate == null) {
			if (other.customDate != null)
				return false;
		} else if (!customDate.equals(other.customDate))
			return false;
		if (incomeId != other.incomeId)
			return false;
		if (incomeType != other.incomeType)
			return false;
		if (operationDate == null) {
			if (other.operationDate != null)
				return false;
		} else if (!operationDate.equals(other.operationDate))
			return false;
		return true;
	}
	
	
	
	

}
