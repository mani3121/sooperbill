package org.sooperbill.service;

import java.io.IOException;

public interface BillingService {
	public byte[] generatePdf(String text) throws IOException;

}
