export interface Service {
  id: string;
  name: string;
  price: string;
  description: string;
  timeInMinutes: string;
}

export interface SlotDto {
  id: string;
  stylistName: string;
  lockedAt: Date;
  service: Service;
  status: string;
  slotFor: Date;
  time: Date;
}

export const fetchServices = async (): Promise<Service[]> => {
  const response = await fetch(`${process.env.REACT_APP_API_URL}/api/services/retrieveAvailableSalonServices`);
  if (!response.ok) {
    throw new Error(`Error: ${response.statusText}`);
  }
  return response.json();
};

export const fetchServiceByDate = async (serviceId: string | undefined, date: string): Promise<SlotDto[]> => {
  const response = await fetch(`${process.env.REACT_APP_API_URL}/api/services/retrieveAvailableSlots/${serviceId}/${date}`);
  if (!response.ok) {
    throw new Error(`Error: ${response.statusText}`);
  }
  return response.json();
};