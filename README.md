mplement a Monitoring and Communication Microservice for the Energy Management System.
The microservice is based on a message broker middleware that gathers data from the smart
metering devices, processes the data to compute the hourly energy consumption and stores it in
the database of the Monitoring and Communication Microservice.
The synchronization between the databases of Device Management Microservice and the new
Monitoring and Communication Microservice is made through an event-based system that uses a
topic for device changes (sends device information through a queue for the Monitoring and
Communication Microservice).
A Smart Metering Device Simulator application will be implemented as the Message Producer. It
will simulate a smart meter by reading energy data from a sensor.csv file (i.e., one value at every
10 minutes) and sends data in the form < timestamp, device_id, measurement_value > to the
Message Broker (i.e., a queue). The timestamp is taken from the local clock, and the device_id is
unique to each instance of the Smart Metering Device Simulator and corresponds to the device_id
of a user from the database.
