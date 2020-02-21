/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.commands.Arm.*;
import frc.robot.commands.BallMove.*;
import frc.robot.commands.Drive.*;
import frc.robot.commands.Intake.teleopBallOut;
import frc.robot.commands.Intake.teleopBallUp;
import frc.robot.commands.Lift.*;
import frc.robot.commands.Pivot.*;
import frc.robot.commands.Shoot.*;
import frc.robot.commands.WheelOfFortune.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  
  public static Chassis m_chassis = new Chassis();
  public static teleopDrive m_teleopDrive = new teleopDrive(m_chassis);

  public static Lift m_lift = new Lift();
  public static teleopLiftUp m_teleopLiftUp = new teleopLiftUp(m_lift);
  public static teleopLiftDown m_teleopLiftDown = new teleopLiftDown(m_lift);
  public static teleopArmUp m_armUpward = new teleopArmUp(m_lift);
  public static teleopArmDown m_armDownward = new teleopArmDown(m_lift);

  public static BallMover m_ballMover = new BallMover();
  public static teleopBallForward m_BallForward = new teleopBallForward(m_ballMover);
  public static teleopBallBackward m_BallBackward = new teleopBallBackward(m_ballMover);
  
  public static Shoot m_Shoot = new Shoot();
  public static teleopShoot m_teleopShoot = new teleopShoot(m_Shoot);
  public static teleopPivotFront m_teleopPivotFront = new teleopPivotFront(m_Shoot);
  public static teleopPivotBack m_teleopPivotBack = new teleopPivotBack(m_Shoot);
  
  public static BallPickup m_ballPickup = new BallPickup();
  public static teleopBallUp m_teleopBallUp = new teleopBallUp(m_ballPickup);
  public static teleopBallOut m_teleopBallOut = new teleopBallOut(m_ballPickup);

  public static WheelOfFortune m_wheelOfFortune = new WheelOfFortune();
  public static teleopWheelForward m_wheelForward = new teleopWheelForward(m_wheelOfFortune);
  public static teleopWheelBack m_wheelBack = new teleopWheelBack(m_wheelOfFortune);

  public static XboxController controller1 = new XboxController(0);
  public static XboxController controller2 = new XboxController(1);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
