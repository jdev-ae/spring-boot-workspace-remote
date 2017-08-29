package com.suru.sbootest1.components;

import org.springframework.stereotype.Service;

@Service("notificationService")
public class NotificationService {
    public String getData() {
        return getClass().getCanonicalName();
    }
}
