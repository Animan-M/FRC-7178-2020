/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallPickup;

public class RetractPickup extends CommandBase {
  
  private final BallPickup m_BallPickup;

  public RetractPickup(BallPickup subsystem) {
    m_BallPickup = subsystem;
    addRequirements(m_BallPickup);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_BallPickup.retractPickup();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
