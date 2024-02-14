import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Navbar } from 'react-bootstrap';

function App() {
  return (
      <div className="App">
          <Navbar bg="dark" variant="dark">
              <Navbar.Brand href="#home">
                  <div style={{ width: '100%', textAlign: 'center', paddingLeft: '25px' }}>
                      AR Salon and Day Spa Services
                  </div>
              </Navbar.Brand>
          </Navbar>
      </div>
  );
}

export default App;
