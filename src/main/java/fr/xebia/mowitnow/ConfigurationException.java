package fr.xebia.mowitnow;

/**
 * Classe d'exception personnalisée.
 *
 * @author Minh-Trieu HA
 */
public class ConfigurationException extends Exception
{
        private static final long serialVersionUID = -4747085865371766402L;

        public ConfigurationException()
        {
        }

        public ConfigurationException(String message)
        {
                super(message);
        }

        public ConfigurationException(Throwable cause)
        {
                super(cause);
        }

        public ConfigurationException(String message, Throwable cause)
        {
                super(message, cause);
        }

        public ConfigurationException(String message, Throwable cause,
                                      boolean enableSuppression, boolean writableStackTrace)
        {
                super(message, cause, enableSuppression, writableStackTrace);
        }

}