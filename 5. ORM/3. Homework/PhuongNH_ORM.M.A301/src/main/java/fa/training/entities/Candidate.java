package fa.training.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "Candidate")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Integer candidateId;

	@NotNull
	@Column(name = "full_name", length = 255)
	private String fullName;

	@NotNull
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Range(min = 0, max = 1)
	@Column(name = "gender")
	private Integer gender;

	@NotNull
	@Column(name = "graduation_year")
	private LocalDate graduationYear;

	@NotNull
	@Column(name = "phone", length = 255, unique = true)
	private String phone;

	@NotNull
	@Email
	@Column(name = "email", length = 255, unique = true)
	private String email;

	@Column(name = "skill", length = 255)
	private String skill;

	@Column(name = "foreign_language", length = 255)
	private String foreignLanguage;

	@Range(min = 1, max = 7)
	@Column(name = "level")
	private Integer level;

	@Column(name = "cv", length = 255)
	private String cv;

	@Column(name = "allocation_status")
	private Integer allocationStatus;

	@Column(name = "remark", length = 1000)
	private String remark;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate", cascade = CascadeType.ALL)
	private Set<EntryTest> entryTest;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate", cascade = CascadeType.ALL)
	private Set<Interview> interview;

	public Candidate() {
	}

	public Candidate(String fullName, LocalDate dateOfBirth, Integer gender, LocalDate graduationYear, String phone,
			String email, String skill, String foreignLanguage, Integer level, String cv, Integer allocationStatus,
			String remark, Set<EntryTest> entryTest, Set<Interview> interview) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.skill = skill;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		this.cv = cv;
		this.allocationStatus = allocationStatus;
		this.remark = remark;
		this.entryTest = entryTest;
		this.interview = interview;
	}

	public Candidate(String fullName, LocalDate dateOfBirth, Integer gender, LocalDate graduationYear, String phone,
			String email, String skill, String foreignLanguage, Integer level, String cv, Integer allocationStatus,
			String remark) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.skill = skill;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		this.cv = cv;
		this.allocationStatus = allocationStatus;
		this.remark = remark;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public LocalDate getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(LocalDate graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getForeignLanguage() {
		return foreignLanguage;
	}

	public void setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Integer getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(Integer allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<EntryTest> getEntryTest() {
		return entryTest;
	}

	public void setEntryTest(Set<EntryTest> entryTest) {
		this.entryTest = entryTest;
	}

	public Set<Interview> getInterview() {
		return interview;
	}

	public void setInterview(Set<Interview> interview) {
		this.interview = interview;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", graduationYear=" + graduationYear + ", phone=" + phone + ", email=" + email
				+ ", skill=" + skill + ", foreignLanguage=" + foreignLanguage + ", level=" + level + ", cv=" + cv
				+ ", allocationStatus=" + allocationStatus + ", remark=" + remark + ", entryTest=" + entryTest
				+ ", interview=" + interview + "]";
	}

}
