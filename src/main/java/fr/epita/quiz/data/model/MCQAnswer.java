package fr.epita.quiz.data.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "T_McqAnswer")
@DynamicInsert(true)
public class MCQAnswer {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "title")
	private Exam exam;
	
	@OneToMany(targetEntity = MCQChoice.class, cascade=CascadeType.ALL)
	@JoinColumn(name="choices")
	List<MCQChoice> choices = new ArrayList<MCQChoice>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student")
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<MCQChoice> getChoices() {
		return choices;
	}

	public void setChoices(List<MCQChoice> choices) {
		this.choices = choices;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
