package org.jboss.errai.bus.server;

import org.jboss.errai.bus.client.api.QueueSession;
import org.jboss.errai.bus.client.api.SessionEndListener;
import org.jboss.errai.bus.server.util.SecureHashUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mike Brock
 */
public abstract class MockQueueSessionFactory {
  public static QueueSession newSession() {
    return new QueueSession() {
      final Map<String, Object> attributes = new HashMap<String, Object>();
      final String sessionId = SecureHashUtil.nextSecureHash();

      @Override
      public String getSessionId() {
        return sessionId;
      }

      @Override
      public String getParentSessionId() {
        return null;
      }

      @Override
      public boolean endSession() {
        return false;
      }

      @Override
      public void setAttribute(String attribute, Object value) {
        attributes.put(attribute, value);
      }

      @Override
      public <T> T getAttribute(Class<T> type, String attribute) {
        return (T) attributes.get(attribute);
      }

      @Override
      public Collection<String> getAttributeNames() {
        return attributes.keySet();
      }

      @Override
      public boolean hasAttribute(String attribute) {
        return attributes.containsKey(attribute);
      }

      @Override
      public Object removeAttribute(String attribute) {
        return attributes.remove(attribute);
      }

      @Override
      public void addSessionEndListener(SessionEndListener listener) {
      }
    };
  }

}
