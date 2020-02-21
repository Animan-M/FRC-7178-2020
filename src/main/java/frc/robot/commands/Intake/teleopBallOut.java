/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BallMover;
import frc.robot.subsystems.BallPickup;

public class teleopBallOut extends CommandBase {
  /**
   * Creates a new teleopBallOut.
 * @param m_ballPickup
   */
  public teleopBallOut(BallPickup m_ballPickup) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_ballPickup);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.controller1.getRawButton(6) == true) {
      BallPickup.m_back.set(-30);
      BallPickup.m_pickup.set(-30);
      BallMover.m_middle.set(30);
    } else {
      BallPickup.m_back.set(0);
      BallPickup.m_pickup.set(0);
      BallMover.m_middle.set(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
