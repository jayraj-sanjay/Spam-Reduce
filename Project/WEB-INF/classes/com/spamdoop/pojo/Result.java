package com.spamdoop.pojo;

import java.util.List;

public class Result {

	private String filename;
	private String is_spam;
	private List<String> spam_words;

	public String getFilename() {

		return filename;

	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getIs_spam() {
		return is_spam;
	}

	public void setIs_spam(String is_spam) {
		this.is_spam = is_spam;
	}

	public List<String> getSpam_words() {
		return spam_words;
	}

	public void setSpam_words(List<String> spam_words) {
		this.spam_words = spam_words;
	}

}
