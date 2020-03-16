package fr.epita.quiz.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Quiz_Database")
public class Question {
	
	public Question() {
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String question;

//	@OneToOne(targetEntity = Answer.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "UserAnswer")
//	private String userAnswer;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
}

