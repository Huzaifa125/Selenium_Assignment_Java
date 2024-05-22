# Use an official Selenium base image
FROM selenium/standalone-chrome:latest

USER root

# Install Firefox
RUN apt-get update && apt-get install -y firefox-esr

# Install Edge
RUN apt-get update && apt-get install -y software-properties-common \
    && curl -sSL https://packages.microsoft.com/keys/microsoft.asc | apt-key add - \
    && add-apt-repository "deb [arch=amd64] https://packages.microsoft.com/repos/edge stable main" \
    && apt-get update && apt-get install -y microsoft-edge-stable

# Install WebDriver Manager
RUN pip install webdrivermanager \
    && webdrivermanager chrome firefox edge --linkpath /usr/local/bin

# Install Xvfb and other dependencies
RUN apt-get install -y xvfb dbus-x11

# Set environment variables
ENV DISPLAY=:99

# Start Xvfb
CMD Xvfb :99 -screen 0 1920x1080x24 & \
    exec "$@"
