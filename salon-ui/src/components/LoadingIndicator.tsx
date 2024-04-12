import React, { useEffect, useState } from 'react';
import { BehaviorSubject } from 'rxjs';

// This is a global loading subject you can import and use throughout your app to control the loading indicator
export const loadingSubject = new BehaviorSubject<boolean>(false);

const LoadingIndicator = () => {
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    const subscription = loadingSubject.subscribe({
      next: (loading) => setIsLoading(loading),
    });
    loadingSubject.next(true);

    return () => subscription.unsubscribe();
  }, []);

  if (!isLoading) return null;

  return (
    <div className="position-fixed bottom-0 start-0 w-100">
      <div className="progress" style={{ height: '4px' }}>
        <div className="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style={{ width: '100%' }}></div>
      </div>
    </div>
  );
};

export default LoadingIndicator;