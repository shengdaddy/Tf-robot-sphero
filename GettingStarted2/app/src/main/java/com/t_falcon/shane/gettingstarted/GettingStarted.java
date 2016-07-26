package com.t_falcon.shane.gettingstarted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.orbotix.ConvenienceRobot;
import com.orbotix.common.DiscoveryAgent;

public class GettingStartedActivity extends ActionBarActivity {
    private DiscoveryAgent _discoveryAgent;
    private ConvenienceRobot _robot;
    public class GettingStartedActivity extends ActionBarActivity {
        private DiscoveryAgent _discoveryAgent;
        private ConvenienceRobot _robot;
    }
};
private RobotChangedStateListener _robotStateListener = new RobotChangedStateListener() {
@Override
public void changedState(Robot robot, RobotChangedStateNotificationType robotChangedStateNotificationType) {
        switch (robotChangedStateNotificationType) {
        case Online:
        Log.i("Connecting", robot + " Online!");
        _robot = new sphero(robot);
        stopDiscovery();

        _robot.setLed(0.f, 1.f, 0.f);
        break;
        }
        }
        };
private void startDiscovery() {
        _discoveryAgent = DiscoveryAgentClassic.getInstance();
        _discoveryAgent.addDiscoveryListener(_discoveryAgentEventListener);
        _discoveryAgent.addRobotStateListener(_robotStateListener);
        try {
        _discoveryAgent.startDiscovery(this);
        } catch (DiscoveryException e) {
        Log.e("Connecting", "Failed to start discovery because " + e);
        e.printStackTrace();
        }
        }

private void stopDiscovery() {
        _discoveryAgent.stopDiscovery();
        _discoveryAgent.removeDiscoveryListener(_discoveryAgentEventListener);
        _discoveryAgent.removeRobotStateListener(_robotStateListener);
        _discoveryAgent = null;
        }
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);

        startDiscovery();
        }