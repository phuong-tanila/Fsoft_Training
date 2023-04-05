package fa.training.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.*;


@Entity
@Table(name = "EntryTest")
@Check(constraints = " result IN('pass','fail')")
public class EntryTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private Integer testId;

	@Column(name = "time", length = 255)
	private String time;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "language_valuator", length = 255)
	private String languageValuator;

	@Range(min = 0, max = 10)
	@Column(name = "language_result")
	private BigDecimal languageResult;

	@Column(name = "technical_valuator", length = 255)
	private String technicalValuator;

	@Range(min = 0, max = 10)
	@Column(name = "technical_result")
	private BigDecimal technicalResult;

	@Column(name = "result", length = 255)
	private String result;

	@Column(name = "remark", length = 1000)
	private String remark;

	@Column(name = "entry_test_skill", length = 255)
	private String entryTestSkill;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	public EntryTest() {
	}

	public EntryTest(Integer testId, String time, LocalDate date, String languageValuator, BigDecimal languageResult,
			String technicalValuator, BigDecimal technicalResult, String result, String remark, String entryTestSkill,
			Candidate candidate) {
		super();
		this.testId = testId;
		this.time = time;
		this.date = date;
		this.languageValuator = languageValuator;
		this.languageResult = languageResult;
		this.technicalValuator = technicalValuator;
		this.technicalResult = technicalResult;
		this.result = result;
		this.remark = remark;
		this.entryTestSkill = entryTestSkill;
		this.candidate = candidate;
	}

	public EntryTest(String time, LocalDate date, String languageValuator, BigDecimal languageResult,
			String technicalValuator, BigDecimal technicalResult, String result, String remark, String entryTestSkill,
			Candidate candidate) {
		super();
		this.time = time;
		this.date = date;
		this.languageValuator = languageValuator;
		this.languageResult = languageResult;
		this.technicalValuator = technicalValuator;
		this.technicalResult = technicalResult;
		this.result = result;
		this.remark = remark;
		this.entryTestSkill = entryTestSkill;
		this.candidate = candidate;
	}

	public EntryTest(String time, LocalDate date, String languageValuator, BigDecimal languageResult,
			String technicalValuator, BigDecimal technicalResult, String result, String remark, String entryTestSkill) {
		super();
		this.time = time;
		this.date = date;
		this.languageValuator = languageValuator;
		this.languageResult = languageResult;
		this.technicalValuator = technicalValuator;
		this.technicalResult = technicalResult;
		this.result = result;
		this.remark = remark;
		this.entryTestSkill = entryTestSkill;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLanguageValuator() {
		return languageValuator;
	}

	public void setLanguageValuator(String languageValuator) {
		this.languageValuator = languageValuator;
	}

	public BigDecimal getLanguageResult() {
		return languageResult;
	}

	public void setLanguageResult(BigDecimal languageResult) {
		this.languageResult = languageResult;
	}

	public String getTechnicalValuator() {
		return technicalValuator;
	}

	public void setTechnicalValuator(String technicalValuator) {
		this.technicalValuator = technicalValuator;
	}

	public BigDecimal getTechnicalResult() {
		return technicalResult;
	}

	public void setTechnicalResult(BigDecimal technicalResult) {
		this.technicalResult = technicalResult;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEntryTestSkill() {
		return entryTestSkill;
	}

	public void setEntryTestSkill(String entryTestSkill) {
		this.entryTestSkill = entryTestSkill;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "EntryTest [testId=" + testId + ", time=" + time + ", date=" + date + ", languageValuator="
				+ languageValuator + ", languageResult=" + languageResult + ", technicalValuator=" + technicalValuator
				+ ", technicalResult=" + technicalResult + ", result=" + result + ", remark=" + remark
				+ ", entryTestSkill=" + entryTestSkill + "]";
	}

}