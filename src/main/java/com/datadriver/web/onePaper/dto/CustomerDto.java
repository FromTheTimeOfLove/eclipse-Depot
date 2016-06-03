package com.datadriver.web.onePaper.dto;

import com.datadriver.core.generic.GenericDto;

public class CustomerDto extends GenericDto {

	private String customercode;

	private String customername;

	public String getCustomercode() {
		return customercode;
	}

	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

}
