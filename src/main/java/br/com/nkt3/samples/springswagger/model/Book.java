package br.com.nkt3.samples.springswagger.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book")
@AllArgsConstructor
@ToString(exclude = "id")
public class Book {

	public Book() { }
	
	@Id
	@Column(name = "id", nullable = false)
	@ApiModelProperty(notes = "Book identification")
	@Getter private Long id;
	
	@NotEmpty(message = "Fill the title")
	@Size(min = 2, message = "Title must be greater than 2 characters")
	@Column(name = "title", nullable = false)
	@ApiModelProperty(notes = "Title of the book")
	@Getter @Setter private String title;
	
	@Column(name = "description", nullable = false)
	@ApiModelProperty(notes = "description of the book")
	@Getter @Setter private String description;

	@NotEmpty(message = "Fill the author")
	@Column(name = "author", nullable = false)
	@ApiModelProperty(notes = "Author of the book")
	@Getter @Setter private String author;

	@NotEmpty(message = "Fill the edition")
	@Column(name = "edition", nullable = false)
	@ApiModelProperty(notes = "Edition of the book")
	@Getter @Setter private String edition;

	@NotNull(message = "Fill the number of pages")
	@Column(name = "pages", nullable = false)
	@ApiModelProperty(notes = "Number of pages of the book")
	@Getter @Setter private Integer pages;

	@NotNull(message = "Fill the launch date")
	@Past(message = "Fill a launch date before the current date")
	@Column(name = "launch_date", nullable = false)
	@ApiModelProperty(notes = "Launch date of the book")
	@Getter @Setter private LocalDate launchDate;

	@Column(name = "status", nullable = false)
	@ApiModelProperty(notes = "Availability of the book")
	@Getter @Setter private String status;

	@NotEmpty(message = "Fill the publisher")
	@Column(name = "publisher", nullable = false)
	@ApiModelProperty(notes = "Publisher of the book")
	@Getter @Setter private String publisher;
}
