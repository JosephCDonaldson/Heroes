package com.herocraftonline.heroes.components;

import org.spongepowered.api.GameState;

/**
 * Acts as a base repository from which component instances can be registered/created/cloned as appropriate.
 */
public interface ComponentManager {
    /**
     * Registers the component with this component manager, must be called during {@link GameState#INITIALIZATION}
     * @param component The component to register
     * @throws java.lang.IllegalStateException if this method is called during any other GameState than INITIALIZAION
     */
    void registerComponent(Component component);

    /**
     * Gets a base component instance with no data values passed in
     * @param name The name of the component, non case-sensitive
     * @param <T> The specific class of the component being retrieved
     * @return The component, or null if no component with a matching name is registered.
     */
    <T extends Component> T getComponent(String name);

    /**
     * Removes the component from this component manager, must be called during {@link GameState#INITIALIZATION}
     * @param name The name of the component, non case-sensitive
     * @param <T> The specific class of the component being removed
     * @return The removed component, or null if no component found
     * @throws java.lang.IllegalStateException if this method is called during any other GameState than INITIALIZAION
     */
    <T extends Component> T removeComponent(String name);
}
