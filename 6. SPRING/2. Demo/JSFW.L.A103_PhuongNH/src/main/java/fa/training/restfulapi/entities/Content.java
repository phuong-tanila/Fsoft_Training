package fa.training.restfulapi.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Content")
public class Content {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "brief")
	private String brief;

	@Column(name = "content")
	private String content;

	@UpdateTimestamp
	@Column(name = "createDate")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "updateTime")
	private Date updateTime;

	@ManyToOne
	@JoinColumn(name = "authorId", referencedColumnName = "id")
	private Member member;

	public Content() {
	}

	public Content(Integer id, String title, String brief, String content, Date createDate, Date updateTime,
			Member member) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createDate = createDate;
		this.updateTime = updateTime;
		this.member = member;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", brief=" + brief + ", content=" + content + ", createDate="
				+ createDate + ", updateTime=" + updateTime + ", member=" + member + "]";
	}

}
