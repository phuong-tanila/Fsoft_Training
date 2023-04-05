package fa.training.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "Interview")
public class Interview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "interview_id")
	private Integer interviewId;

	@Column(name = "time", length = 255)
	private String time;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "interviewer", length = 255)
	private String interviewer;

	@Column(name = "comments", length = 2000)
	private String comments;

	@Column(name = "interview_result", length = 255)
	private String interviewResult;

	@Column(name = "remark", length = 1000)
	private String remark;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	public Interview() {
	}

	public Interview(Integer interviewId, String time, LocalDate date, String interviewer, String comments,
			String interviewResult, String remark, Candidate candidate) {
		super();
		this.interviewId = interviewId;
		this.time = time;
		this.date = date;
		this.interviewer = interviewer;
		this.comments = comments;
		this.interviewResult = interviewResult;
		this.remark = remark;
		this.candidate = candidate;
	}

	public Interview(String time, LocalDate date, String interviewer, String comments, String interviewResult,
			String remark, Candidate candidate) {
		super();
		this.time = time;
		this.date = date;
		this.interviewer = interviewer;
		this.comments = comments;
		this.interviewResult = interviewResult;
		this.remark = remark;
		this.candidate = candidate;
	}

	public Interview(String time, LocalDate date, String interviewer, String comments, String interviewResult,
			String remark) {
		super();
		this.time = time;
		this.date = date;
		this.interviewer = interviewer;
		this.comments = comments;
		this.interviewResult = interviewResult;
		this.remark = remark;
	}

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
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

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getInterviewResult() {
		return interviewResult;
	}

	public void setInterviewResult(String interviewResult) {
		this.interviewResult = interviewResult;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Interview [interviewId=" + interviewId + ", time=" + time + ", date=" + date + ", interviewer="
				+ interviewer + ", comments=" + comments + ", interviewResult=" + interviewResult + ", remark=" + remark
				+ "]";
	}

}