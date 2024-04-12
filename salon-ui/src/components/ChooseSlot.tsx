import React, { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import {useParams} from "react-router-dom";
import {fetchServiceByDate, SlotDto} from "../services/BackendService";

export const ChooseSlot = () => {
    const { serviceId: routerServiceId, serviceName: routerServiceName } = useParams();
    const [serviceId] = useState(routerServiceId);
    const [serviceName] = useState(routerServiceName);
    const [startDate, setStartDate] = useState(new Date());
    const [services, setServices] = useState<SlotDto[]>([]);

    const fetchServices = async () => {
        const formattedDate = startDate.toISOString().split('T')[0];
        console.log("fetchSlots called with", formattedDate, " and serviceId: ", serviceId);
        const services = await fetchServiceByDate(serviceId, formattedDate);
        setServices(services);
    };

    return (
        <div className="container mt-3" style={{ paddingTop: '70px' }}>
            <div className="row">
                <div className="col">
                    Choose date for {serviceName}
                </div>
                <div className="col">
                    <DatePicker
                        selected={startDate}
                        onChange={(date) => date ? setStartDate(date) : setStartDate(new Date())}
                    />
                </div>
                <div className="col">
                    <button className="btn btn-primary" onClick={fetchServices}>Show slots</button>
                </div>
            </div>
            <div>Available slots on {startDate.toISOString().split('T')[0]}</div>
            <div className="row">
                {services.map((service, index) => {
                    const date = new Date(service.slotFor);
                    const hours = date.getHours();
                    const minutes = date.getMinutes();
                    const formattedTime = `${hours}:${minutes < 10 ? '0' : ''}${minutes}`;

                    return (
                        <div key={service.id} className="col-sm-4 mb-4">
                            <div className="card">
                                <div className="card-header text-center">{serviceName}</div>
                                <div className="card-body text-center">
                                    <h3 className="card-title">{service.stylistName}</h3>
                                    <p className="card-text">Slot time {formattedTime}</p>
                                    <button className="btn btn-outline-primary">Book this slot</button>
                                </div>
                            </div>
                        </div>
                    );
                })}
            </div>
        </div>
    );
};