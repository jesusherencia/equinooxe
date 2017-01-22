package com.equinooxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.equinooxe.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> , JpaSpecificationExecutor<Notification> {
}

