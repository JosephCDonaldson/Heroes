package com.herocraftonline.heroes.common.characters;

import com.herocraftonline.heroes.Heroes;
import com.herocraftonline.heroes.characters.CharacterBase;
import com.herocraftonline.heroes.components.Component;
import com.herocraftonline.heroes.effects.EffectBase;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public abstract class CharacterCommon implements CharacterBase {
    private final Map<String, Component> components;
    private final Map<String, EffectBase> effects;

    public CharacterCommon() {
        components = new HashMap<String, Component>();
        effects = new HashMap<String, EffectBase>();
    }

    @Override
    public void addEffect(EffectBase effect) {
        effect.apply(this);
        effects.put(effect.getName().toLowerCase(), effect);
    }

    @Override
    public EffectBase getEffect(String name) {
        return effects.get(name.toLowerCase());
    }

    @Override
    public Collection<EffectBase> getEffects() {
        return Collections.unmodifiableCollection(effects.values());
    }

    @Override
    public boolean hasEffect(String name) {
        return effects.containsKey(name.toLowerCase());
    }

    @Override
    public EffectBase removeEffect(String name) {
        return effects.remove(name.toLowerCase());
    }

    @Override
    public boolean hasComponent(String name) {
        return components.containsKey(name);
    }

    @Override
    public Component getComponent(String name) {
        return components.get(name);
    }

    @Override
    public boolean registerComponent(Component component) {
        if (!components.containsKey(component.getName())) {
            component.onAttach(this);
            components.put(component.getName(), component);
            return true;
        } else {
            Heroes.getInstance().getLogger().log(Level.WARNING, "Duplicate component registration "
                    + component.getName() + " attempted, skipping!");
            return false;
        }
    }

    @Override
    public Component unregisterComponent(String name) {
        Component removed = components.remove(name);
        if (removed != null) {
            removed.onRemove(this);
        }
        return removed;
    }
}