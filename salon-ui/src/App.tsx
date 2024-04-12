import React, { useEffect } from 'react';
import './App.css';
import LoadingIndicator, { loadingSubject } from './components/LoadingIndicator';
import Notifications, { notificationSubject } from './components/Notifications';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import {ChooseSlot} from "./components/ChooseSlot";
import ChooseService from "./components/ChooseService";

function App() {

    useEffect(() => {
        notificationSubject.next({ type: 'info', message: 'Page is loading...' });
        loadingSubject.next(true);

        setTimeout(() => {
          // Stop loading after 3 seconds
          notificationSubject.next(null);
          loadingSubject.next(false);
        }, 3000);

      }, []);

    return (
        <Router>
            <div>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
                    <a className="navbar-brand" href="/">Ar Salon & Day Spa!</a>
                </nav>
                <main role="main" className="container">
                    <div className="padding-container">
                        <Routes>
                            <Route path="/" element={<ChooseService />} />
                            <Route path="/chooseslot/:serviceId/:serviceName" element={<ChooseSlot />} />
                        </Routes>
                    </div>
                </main>
                <LoadingIndicator/>
                <Notifications />
            </div>
        </Router>

    );
}

export default App;