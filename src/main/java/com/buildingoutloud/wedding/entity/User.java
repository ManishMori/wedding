package com.buildingoutloud.wedding.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
/**
 * 
 * Entity mapped to user table
 */
@Entity
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private int id;
	
	@Column(name = "user_first_name")
	private String firstName;
	
	@Column(name = "user_last_name")
	private String lastName;
	
	@Column(name = "user_full_name")
	private String fullName;
	
	@Column(name = "user_gender")
	private String gender;
	
	@Column(name = "user_d_o_b")
	private LocalDate DOB;
	
	@Column(name = "user_marriage_date")
	private LocalDate marriageDate;
	
	@Column(name = "user_document_aadhar")
	@Lob
	private byte[] documentAadhar;
	
	@Column(name = "user_document_marriage_certificate")
	@Lob
	private byte[] documentMarriageCertificate;
	
	@Column(name = "user_document_mariage_picture")
	@Lob
	private byte[] documentMariagePicture;
	
	@Column(name = "user_certificate_id")
	private String certificateId;
	
	@OneToOne
	@JoinColumn(name = "partner_user_id")
	private User partnerUserId;
	
	@Column(name = "is_documents_approved")
	private boolean documentsApproved;
	
	@Column(name = "is_contract_generated")
	private boolean contractGenerated;
	
	@Column(name = "is_user_active")
	private boolean active;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "password")
	private String password;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	public byte[] getDocumentAadhar() {
		return documentAadhar;
	}

	/**
	 * @param documentAadhar the documentAadhar to set
	 */
	public void setDocumentAadhar(byte[] documentAadhar) {
		this.documentAadhar = documentAadhar;
	}

	/**
	 * @return the documentMarriageCertificate
	 */
	public byte[] getDocumentMarriageCertificate() {
		return documentMarriageCertificate;
	}

	/**
	 * @param documentMarriageCertificate the documentMarriageCertificate to set
	 */
	public void setDocumentMarriageCertificate(byte[] documentMarriageCertificate) {
		this.documentMarriageCertificate = documentMarriageCertificate;
	}

	/**
	 * @return the documentMariagePicture
	 */
	public byte[] getDocumentMariagePicture() {
		return documentMariagePicture;
	}

	/**
	 * @param documentMariagePicture the documentMariagePicture to set
	 */
	public void setDocumentMariagePicture(byte[] documentMariagePicture) {
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
	public User getPartnerUserId() {
		return partnerUserId;
	}

	/**
	 * @param partnerUserId the partnerUserId to set
	 */
	public void setPartnerUserId(User partnerUserId) {
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
	 * @return the userActive
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param userActive the userActive to set
	 */
	public void setActive(boolean active) {
		this.active = active;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
