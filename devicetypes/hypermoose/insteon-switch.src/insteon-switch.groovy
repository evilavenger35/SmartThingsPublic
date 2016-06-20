/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *	Insteon Switch
 *
 *	Author: hypermoose
 *	Date: 2016-06-19
 */
metadata {
	definition (name: "Insteon Switch", namespace: "hypermoose", author: "hypermoose") {
		capability "Actuator"
		capability "Switch"
        capability "Sensor"
	}

	tiles {
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
            state "off", label: '${name}', action: "switch.on",
                   icon: "st.switches.switch.off", backgroundColor: "#ffffff"
            state "on", label: 'AM ON', action: "switch.off",
                  icon: "st.switches.switch.on", backgroundColor: "#79b821"
        }
		main "switch"
		details "switch"
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
}

def off() {
	log.debug "off"
	def deviceId = device.deviceNetworkId.split(/\./).last()
	if (!parent.switchOff(this, deviceId)) {
		log.debug "Error turning switch off"
	}
}

def on() {
	log.debug "on"
	def deviceId = device.deviceNetworkId.split(/\./).last()
	if (!parent.switchOn(this, deviceId)) {
		log.debug "Error turning switch on"
	}
}

