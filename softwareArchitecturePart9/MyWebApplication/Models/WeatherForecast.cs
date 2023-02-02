namespace MyWebApplication.Models
{
    public class WeatherForecast
    {
        /// <summary>
        /// Дата измерения
        /// </summary>
        public DateTime Date { get; set; }  

        /// <summary>
        /// Температура в градусах С
        /// </summary>
        public int TemperatureC { get; set; }
        /// <summary>
        /// температура в градусах F
        /// </summary>
        public int TemperatureF {
            get { return 32 + (int)(TemperatureC / 0.5556); }
        }

        public WeatherForecast(DateTime dateTime, int temperature) { 
            Date = dateTime;
            TemperatureC = temperature;
        }

    }
}
