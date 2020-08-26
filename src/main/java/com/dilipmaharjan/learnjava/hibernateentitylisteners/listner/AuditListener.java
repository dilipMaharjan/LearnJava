package com.dilipmaharjan.learnjava.hibernateentitylisteners.listner;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuditListener {

	@PrePersist
	private void beforePersist(Object object) {
		log.info("Before  Persist------------->>>");
	}

	@PreUpdate
	private void beforeAnyUpdate(Object object) {
		log.info("Before Update------------->>>");
	}

	@PreRemove
	private void beforeRemove(Object object) {
		log.info("Before Remove------------->>>");
	}

	@PostPersist
	private void afterPersist(Object object) {
		log.info("After Persist--------------->>>");
	}

	@PostUpdate
	private void afterUpdate(Object object) {
		log.info("After update--------------->>>");
	}

	@PostRemove
	private void afterRemove(Object object) {
		log.info("After Remove--------------->>>");
	}

	@PostLoad
	private void afterLoad(Object object) {
		log.info("After load ------------->>>");
	}
}
