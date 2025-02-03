package org.sooperbill.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.sooperbill.service.BillingService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bill")
public class BillingController {
	
	private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

	 @PostMapping("/generate")
	    public ResponseEntity<byte[]> generatePdf(@RequestBody Map<String, String> requestBody) {
	        try {
	            String text = requestBody.getOrDefault("text", "Default PDF Content");

	            byte[] pdfBytes = billingService.generatePdf(text);

	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_PDF);
	            headers.setContentDispositionFormData("attachment", "generated.pdf");
	            headers.setContentLength(pdfBytes.length);

	            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body(("Error generating PDF: " + e.getMessage()).getBytes(StandardCharsets.UTF_8));
	        }
	    }
}
