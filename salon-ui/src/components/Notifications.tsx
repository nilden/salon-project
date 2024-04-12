import React, {useEffect, useState} from 'react';
import {BehaviorSubject} from 'rxjs';

export const notificationSubject = new BehaviorSubject<{ type: string, message: string } | null>(null);

const AppNotificationComponent = () => {
    const [notification, setNotification] = useState<{ type: string, message: string } | null>(null);

    useEffect(() => {
        const subscription = notificationSubject.subscribe({
            next: (notification) => setNotification(notification),
        });

        return () => subscription.unsubscribe();
    }, []);

    if (!notification) return null;

    return (
        <div className="position-fixed bottom-0 start-0 w-100">
            <div className={`alert ${notification.type === 'error' ? 'alert-danger' : 'alert-success'}`} role="alert">
                {notification.message}
            </div>
        </div>
    );
};

export default AppNotificationComponent;
