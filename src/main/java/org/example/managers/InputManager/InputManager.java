package org.example.managers.InputManager;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class InputManager implements IInputManager{
    private String state = null;

    private final Map<Integer, Runnable> inputMap;
    JFrame jFrame;

    public InputManager() {
        jFrame = new JFrame();

        inputMap = new HashMap<>();
        inputMap.put(KeyEvent.VK_A, () -> handleInput(InputKeys.MOVE_LEFT));
        inputMap.put(KeyEvent.VK_D, () -> handleInput(InputKeys.MOVE_RIGHT));
        inputMap.put(KeyEvent.VK_S, () -> handleInput(InputKeys.MOVE_DOWN));
        inputMap.put(KeyEvent.VK_Q, () -> handleInput(InputKeys.ROTATE_LEFT));
        inputMap.put(KeyEvent.VK_E, () -> handleInput(InputKeys.ROTATE_RIGHT));
        inputMap.put(KeyEvent.VK_ESCAPE, () -> handleInput(InputKeys.EXIT));

    }

    @Override
    public void listen() {
        jFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                inputMap.getOrDefault(keyCode, () -> state = null).run();
            }
        });

        jFrame.setVisible(true);
    }

    private void handleInput(String input) {
        state = input;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void clear() {
        state = null;
    }
}
