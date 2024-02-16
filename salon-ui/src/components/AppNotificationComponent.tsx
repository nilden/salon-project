import React, { useEffect, useState } from 'react';
import { BehaviorSubject } from 'rxjs';


// This is a global notification subject you can import and use throughout your app to control the notifications
export const notificationSubject = new BehaviorSubject<{type: string, message: string} | null>(null);

const AppNotificationComponent = () => {
  const [notification, setNotification] = useState<{type: string, message: string} | null>(null);

  useEffect(() => {
    const subscription = notificationSubject.subscribe({
      next: (notification) => setNotification(notification),
    });

    return () => subscription.unsubscribe();
  }, []);

  if (!notification) return null;

  return (
    <div className={`alert ${notification.type === 'error' ? 'alert-danger' : 'alert-success'}`} role="alert">
      {notification.message}
    </div>
  );
};

export default AppNotificationComponent;
