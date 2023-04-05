package fa.training.entity;



import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

import fa.training.constants.*;

@Entity
@Table(schema = "dbo", name = "ASSIGNMENT")
public class Assignment {

	@Id
	@Column(name = "code_id")
	@NotNull(message = "Please enter code_id")
	private String codeId;

	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false, referencedColumnName = "id")
	private Subject subject;

	@Column(name = "author_id", nullable = false)
	@NotNull(message = "Please enter author_id")
	private int authorId;

	@Column(name = "released_date")
//	@NotEmpty(message = "Please enter release date")
	private LocalDate releasedDate;

	@Column(name = "estimate_time", nullable = false)
//	@NotEmpty(message = "Please enter estimate time")
	private int estimateTime;

	@Column(name = "path_file", nullable = false)
	@Pattern(regexp = "^.*((.pdf)|(doc))$", message = "File is invalid")
	@NotEmpty(message = "Please add file (.pdf/.doc)")
	private String pathFile;

	@Column(name = "type", nullable = false)
//	@NotEmpty(message = "Please enter type of assignment")
	@Enumerated(EnumType.STRING)
	private Type type;

	@Column(name = "status", nullable = false)
//	@NotEmpty(message = "Please set status of assignment")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "created_on", updatable = false)
	@CreationTimestamp
	private LocalDate createdOn;

	public Assignment() {
	}

	public Assignment(String codeId, Subject subject, int authorId, LocalDate releasedDate, int estimateTime,
			String pathFile, Type type, Status status, LocalDate createdOn) {
		super();
		this.codeId = codeId;
		this.subject = subject;
		this.authorId = authorId;
		this.releasedDate = releasedDate;
		this.estimateTime = estimateTime;
		this.pathFile = pathFile;
		this.type = type;
		this.status = status;
		this.createdOn = createdOn;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}

	public int getEstimateTime() {
		return estimateTime;
	}

	public void setEstimateTime(int estimateTime) {
		this.estimateTime = estimateTime;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Assignment [codeId=" + codeId + ", authorId=" + authorId + ", releasedDate="
				+ releasedDate + ", estimateTime=" + estimateTime + ", pathFile=" + pathFile + ", type=" + type
				+ ", status=" + status + ", createdOn=" + createdOn + "]";
	}

}
