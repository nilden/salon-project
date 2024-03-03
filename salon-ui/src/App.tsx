import React, { useEffect } from 'react';
import './App.css';
import { Navbar } from 'react-bootstrap';
import LoadingIndicator, { loadingSubject } from './components/LoadingIndicator';
import Notifications, { notificationSubject } from './components/Notifications';
import BackendService from './services/BackendService';

function App() {

    useEffect(() => {
        notificationSubject.next({ type: 'info', message: 'Start page is loading...' });
        // Start loading
        loadingSubject.next(true);
        
        // Simulate an async operation like fetching data
        setTimeout(() => {
          // Stop loading after 3 seconds
          notificationSubject.next(null);
          loadingSubject.next(false);
        }, 3000);
       
      }, []);

    return (
        <div className="App">
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="#home">
                    <div style={{ width: '100%', textAlign: 'center', paddingLeft: '25px' }}>
                        AR Salon and Day Spa Services
                    </div>
                </Navbar.Brand>
            </Navbar>
            <LoadingIndicator />
            <BackendService/>
            <div className="fixed-bottom">
                <Notifications />
            </div>

        </div>
    );
}

export default App;