package com.buildingoutloud.wedding.pojo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserResponse {

	private String id;
	
	private boolean isError;
	
	private String errorMessage;
	
	private String firstName;
	
	private String lastName;
	
	private String fullName;
	
	private String gender;
	
	private LocalDate DOB;
	
	private LocalDate marriageDate;
	
	private String documentAadhar;
	
	private String documentMarriageCertificate;
	
	private String documentMariagePicture;
	
	private String certificateId;
	
	private String partnerUserId;
	
	private boolean documentsApproved;
	
	private boolean contractGenerated;
	
	private boolean active;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dOB
	 */
	public LocalDate getDOB() {
		return DOB;
	}

	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	/**
	 * @return the marriageDate
	 */
	public LocalDate getMarriageDate() {
		return marriageDate;
	}

	/**
	 * @param marriageDate the marriageDate to set
	 */
	public void setMarriageDate(LocalDate marriageDate) {
		this.marriageDate = marriageDate;
	}

	/**
	 * @return the documentAadhar
	 */
	public String getDocumentAadhar() {
		return documentAadhar;
	}

	/**
	 * @param documentAadhar the documentAadhar to set
	 */
	public void setDocumentAadhar(String documentAadhar) {
		this.documentAadhar = documentAadhar;
	}

	/**
	 * @return the documentMarriageCertificate
	 */
	public String getDocumentMarriageCertificate() {
		return documentMarriageCertificate;
	}

	/**
	 * @param documentMarriageCertificate the documentMarriageCertificate to set
	 */
	public void setDocumentMarriageCertificate(String documentMarriageCertificate) {
		this.documentMarriageCertificate = documentMarriageCertificate;
	}

	/**
	 * @return the documentMariagePicture
	 */
	public String getDocumentMariagePicture() {
		return documentMariagePicture;
	}

	/**
	 * @param documentMariagePicture the documentMariagePicture to set
	 */
	public void setDocumentMariagePicture(String documentMariagePicture) {
		this.documentMariagePicture = documentMariagePicture;
	}

	/**
	 * @return the certificateId
	 */
	public String getCertificateId() {
		return certificateId;
	}

	/**
	 * @param certificateId the certificateId to set
	 */
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	/**
	 * @return the partnerUserId
	 */
	public String getPartnerUserId() {
		return partnerUserId;
	}

	/**
	 * @param partnerUserId the partnerUserId to set
	 */
	public void setPartnerUserId(String partnerUserId) {
		this.partnerUserId = partnerUserId;
	}

	/**
	 * @return the documentsApproved
	 */
	public boolean isDocumentsApproved() {
		return documentsApproved;
	}

	/**
	 * @param documentsApproved the documentsApproved to set
	 */
	public void setDocumentsApproved(boolean documentsApproved) {
		this.documentsApproved = documentsApproved;
	}

	/**
	 * @return the contractGenerated
	 */
	public boolean isContractGenerated() {
		return contractGenerated;
	}

	/**
	 * @param contractGenerated the contractGenerated to set
	 */
	public void setContractGenerated(boolean contractGenerated) {
		this.contractGenerated = contractGenerated;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the isError
	 */
	public boolean isError() {
		return isError;
	}

	/**
	 * @param isError the isError to set
	 */
	public void setError(boolean isError) {
		this.isError = isError;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
