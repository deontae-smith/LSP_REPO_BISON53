Deontae Smith
# ATC System via CRC

## CRC Card
**Class:** TransponderSignalReceiver  

**Responsibilities:**  
- Receive aircraft transponder packets  
- Validate packet integrity  
- Sends packets for decoding  

**Collaborators:**  
- PacketDecoder  
- SystemLogger  

**Assumptions:**  
- Aircraft continuously broadcast data through transponders  
- Packets arrive in a format that can be validated before sending to decoding  


## CRC Card
**Class:** PacketDecoder  

**Responsibilities:**  
- Decode validated transponder packets  
- Extract aircraft identification, position, altitude, and speed  
- Convert raw packet data into structured aircraft data object  

**Collaborators:**  
- TransponderSignalReceiver  
- AircraftTracker  
- SystemLogger  

**Assumptions:**  
- Incoming packets are already validated  
- Packet format follows the defined transponder communTransponderSignalReceiverTransponderSignalReceiverTransponderSignalReceiverTransponderSignalReceiverication standard  


## CRC Card
**Class:** AircraftTracker  

**Responsibilities:**  
- Maintain a list of active aircraft in the airspace  
- Update aircraft position and flight information  
- Remove aircraft that are no longer transmitting  

**Collaborators:**  
- PacketDecoder  
- CollisionDetector  
- ATCDisplaySystem  
- FlightDataRepository  

**Assumptions:**  
- Each aircraft has a unique identifier  
- Updates are received frequently enough to track aircraft movement  


## CRC Card
**Class:** CollisionDetector  

**Responsibilities:**  
- Monitor aircraft positions and altitudes  
- Detect potential conflicts between aircraft  
- Generate alerts for possible collisions  

**Collaborators:**  
- AircraftTracker  
- ConflictAlertManager  
- AirspaceMonitor  

**Assumptions:**  
- Aircraft positions are continuously updated  
- Conflict detection thresholds are predefined  


## CRC Card
**Class:** ConflictAlertManager  

**Responsibilities:**  
- Receive conflict alerts from the collision detector  
- Prioritize alerts via 1-3
- Log alerts
- Send alerts to the display system for controllers  

**Collaborators:**  
- CollisionDetector  
- ControllerNotificationService  
- ATCDisplaySystem  

**Assumptions:**  
- Alerts are delivered immediately to air traffic controllers  


## CRC Card
**Class:** ATCDisplaySystem  

**Responsibilities:**  
- Display aircraft positions on the radar screen  
- Show aircraft details: ID, altitude, speed, heading
- Display collision warnings and alerts  

**Collaborators:**  
- AircraftTracker  
- AlertManager  
- FlightRecordManager  

**Assumptions:**  
- Controllers rely on this interface for real-time monitoring  
- The display updates whenever aircraft data changes  


## CRC Card
**Class:** FlightRecordManager

**Responsibilities:**  
- Maintain records of registered flights expected in the airspace  
- Store aircraft identification and flight plan information  
- Provide flight information when requested by other components  

**Collaborators:**  
- AircraftTracker  
- ATCDisplaySystem  

**Assumptions:**  
- Each flight has a unique flight identifier  
- Flight plans are submitted before entering the monitored airspace  


## CRC Card
**Class:** FlightDataRepository  

**Responsibilities:**  
- Store historical aircraft tracking data  
- Save flight data for later analysis or auditing  
- Provide retrieval of past flight information  

**Collaborators:**  
- AircraftTracker  
- SystemLogger  

**Assumptions:**  
- Historical data storage is required for safety and investigation purposes  
- Data can be accessed by authorized systems or personnel  


## CRC Card
**Class:** SystemLogger  

**Responsibilities:**  
- Record system events and errors  
- Log incoming aircraft packets and processing steps  
- Maintain logs for debugging and auditing  

**Collaborators:**  
- TransponderSignalReceiver  
- PacketDecoder  
- FlightDataRepository  

**Assumptions:**  
- All critical system events must be logged  
- Logs may be reviewed for system monitoring and troubleshooting  


## CRC Card
**Class:** AirspaceMonitor  

**Responsibilities:**  
- Monitor aircraft movement within defined airspace boundaries  
- Detect aircraft entering or leaving the monitored airspace  
- Notify other components when airspace status changes  

**Collaborators:**  
- AircraftTracker  
- ATCDisplaySystem  
- CollisionDetector  

**Assumptions:**  
- Airspace boundaries are predefined  
- Aircraft positions are continuously updated by the tracker  


## CRC Card
**Class:** ControllerNotificationService  

**Responsibilities:**  
- Send notifications or warnings to air traffic controllers  
- Manage different types of alerts (collision risk, system errors, airspace violations)  
- Ensure alerts are delivered with appropriate priority  

**Collaborators:**  
- AlertManager  
- ATCDisplaySystem  
- SystemLogger  

**Assumptions:**  
- Controllers must receive high-priority alerts immediately  
- Notification channels are reliable and monitored  