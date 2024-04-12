import React, { useState, useEffect } from 'react';
import LoadingIndicator from '../components/LoadingIndicator';
import { notificationSubject } from './Notifications';
import {useNavigate} from "react-router-dom";
import { Service, fetchServices } from '../services/BackendService';

const ChooseService = () => {
    const [services, setServices] = useState<Service[]>([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();

    useEffect(() => {
        setLoading(true);
        fetchServices()
            .then(setServices)
            .catch((error) => {
                setError(error.message);
                notificationSubject.next({ type: 'error', message: "Failed to fetch services" });
            })
            .finally(() => setLoading(false));
    }, []);

    if (loading) return <LoadingIndicator />;
    if (error) return <div>Error: {error}</div>;

    return (
        <div className="container mt-3">
            <div className="row">
                {services.map((service) => (
                    <div key={service.id} className="col-sm-4 mb-4">
                        <div className="card">
                            <div className="card-header">{service.name}</div>
                            <div className="card-body">
                                <h5 className="card-title">${service.price}</h5>
                                <p className="card-text">{service.description}</p>
                                <p className="card-text">{service.timeInMinutes} Minutes</p>
                                <a onClick={() => navigate(`/chooseslot/${service.id}/${service.name}`)}
                                   className="btn btn-outline-primary">Book Now</a>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default ChooseService;