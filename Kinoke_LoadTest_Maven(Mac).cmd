# Get full path of this script file.
ABS_PATH=$(cd "$(dirname "$0")"; pwd)
cd "$ABS_PATH"
#ls .

mvn -Dtest=wav.ios.test.AutomatingKinokeiOSTest test

echo Done.