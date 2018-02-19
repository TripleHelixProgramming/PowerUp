package org.usfirst.frc.team319.paths;

import org.usfirst.frc.team319.models.SrxMotionProfile;
import org.usfirst.frc.team319.models.SrxTrajectory;

public class SameSideSwitch extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (2.75,0.00,0.00)
	// (12.08,1.42,0.00)
	// (15.42,-1.83,-89.00)
	
	public SameSideSwitch() {
		this(false);
	}
			
    public SameSideSwitch(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{0.012,0.244,10.000},
				{0.061,0.488,10.000},
				{0.171,1.097,10.000},
				{0.366,1.951,10.000},
				{0.658,2.926,10.000},
				{1.048,3.901,10.000},
				{1.536,4.876,10.000},
				{2.121,5.850,10.000},
				{2.803,6.824,10.000},
				{3.583,7.797,10.000},
				{4.460,8.770,10.000},
				{5.434,9.743,10.000},
				{6.506,10.714,10.000},
				{7.674,11.685,10.000},
				{8.940,12.655,10.000},
				{10.302,13.625,10.000},
				{11.762,14.593,10.000},
				{13.318,15.560,10.000},
				{14.970,16.527,10.000},
				{16.719,17.492,10.000},
				{18.565,18.456,10.000},
				{20.507,19.418,10.000},
				{22.545,20.380,10.000},
				{24.679,21.340,10.000},
				{26.909,22.299,10.000},
				{29.234,23.256,10.000},
				{31.655,24.211,10.000},
				{34.172,25.165,10.000},
				{36.784,26.118,10.000},
				{39.491,27.069,10.000},
				{42.292,28.018,10.000},
				{45.189,28.965,10.000},
				{48.180,29.910,10.000},
				{51.265,30.854,10.000},
				{54.445,31.795,10.000},
				{57.718,32.735,10.000},
				{61.085,33.672,10.000},
				{64.546,34.607,10.000},
				{68.100,35.541,10.000},
				{71.747,36.472,10.000},
				{75.487,37.401,10.000},
				{79.320,38.327,10.000},
				{83.245,39.252,10.000},
				{87.263,40.174,10.000},
				{91.372,41.093,10.000},
				{95.573,42.011,10.000},
				{99.866,42.926,10.000},
				{104.249,43.838,10.000},
				{108.724,44.748,10.000},
				{113.290,45.656,10.000},
				{117.946,46.561,10.000},
				{122.692,47.463,10.000},
				{127.528,48.363,10.000},
				{132.454,49.260,10.000},
				{137.470,50.155,10.000},
				{142.575,51.047,10.000},
				{147.768,51.936,10.000},
				{153.051,52.823,10.000},
				{158.421,53.707,10.000},
				{163.880,54.589,10.000},
				{169.427,55.467,10.000},
				{175.061,56.344,10.000},
				{180.783,57.217,10.000},
				{186.592,58.088,10.000},
				{192.487,58.956,10.000},
				{198.469,59.821,10.000},
				{204.538,60.684,10.000},
				{210.692,61.544,10.000},
				{216.932,62.402,10.000},
				{223.258,63.256,10.000},
				{229.669,64.109,10.000},
				{236.165,64.958,10.000},
				{242.745,65.805,10.000},
				{249.410,66.649,10.000},
				{256.159,67.491,10.000},
				{262.992,68.331,10.000},
				{269.909,69.167,10.000},
				{276.909,70.002,10.000},
				{283.993,70.834,10.000},
				{291.159,71.663,10.000},
				{298.408,72.490,10.000},
				{305.739,73.315,10.000},
				{313.153,74.137,10.000},
				{320.649,74.957,10.000},
				{328.226,75.775,10.000},
				{335.886,76.591,10.000},
				{343.626,77.405,10.000},
				{351.448,78.217,10.000},
				{359.350,79.026,10.000},
				{367.334,79.834,10.000},
				{375.398,80.640,10.000},
				{383.542,81.444,10.000},
				{391.767,82.246,10.000},
				{400.072,83.047,10.000},
				{408.456,83.846,10.000},
				{416.920,84.643,10.000},
				{425.464,85.439,10.000},
				{434.088,86.234,10.000},
				{442.790,87.027,10.000},
				{451.572,87.819,10.000},
				{460.433,88.610,10.000},
				{469.373,89.400,10.000},
				{478.392,90.189,10.000},
				{487.490,90.977,10.000},
				{496.666,91.764,10.000},
				{505.921,92.551,10.000},
				{515.255,93.337,10.000},
				{524.667,94.123,10.000},
				{534.158,94.908,10.000},
				{543.727,95.693,10.000},
				{553.375,96.478,10.000},
				{563.101,97.263,10.000},
				{572.906,98.049,10.000},
				{582.790,98.834,10.000},
				{592.752,99.620,10.000},
				{602.792,100.406,10.000},
				{612.912,101.194,10.000},
				{623.110,101.981,10.000},
				{633.387,102.770,10.000},
				{643.743,103.560,10.000},
				{654.178,104.352,10.000},
				{664.692,105.144,10.000},
				{675.286,105.938,10.000},
				{685.960,106.734,10.000},
				{696.713,107.532,10.000},
				{707.546,108.331,10.000},
				{718.459,109.133,10.000},
				{729.453,109.937,10.000},
				{740.527,110.743,10.000},
				{751.682,111.553,10.000},
				{762.919,112.364,10.000},
				{774.237,113.179,10.000},
				{785.637,113.997,10.000},
				{797.118,114.819,10.000},
				{808.683,115.644,10.000},
				{820.330,116.472,10.000},
				{832.061,117.305,10.000},
				{843.875,118.141,10.000},
				{855.773,118.981,10.000},
				{867.755,119.826,10.000},
				{879.823,120.676,10.000},
				{891.976,121.530,10.000},
				{904.215,122.389,10.000},
				{916.540,123.253,10.000},
				{928.952,124.122,10.000},
				{941.452,124.997,10.000},
				{954.040,125.877,10.000},
				{966.716,126.763,10.000},
				{979.482,127.656,10.000},
				{992.337,128.554,10.000},
				{1005.283,129.458,10.000},
				{1018.320,130.369,10.000},
				{1031.448,131.286,10.000},
				{1044.669,132.211,10.000},
				{1057.984,133.142,10.000},
				{1071.392,134.080,10.000},
				{1084.894,135.025,10.000},
				{1098.492,135.978,10.000},
				{1112.186,136.939,10.000},
				{1125.977,137.907,10.000},
				{1139.865,138.883,10.000},
				{1153.852,139.867,10.000},
				{1167.937,140.859,10.000},
				{1182.123,141.859,10.000},
				{1196.410,142.867,10.000},
				{1210.798,143.885,10.000},
				{1225.289,144.910,10.000},
				{1239.884,145.944,10.000},
				{1254.583,146.988,10.000},
				{1269.387,148.040,10.000},
				{1284.297,149.101,10.000},
				{1299.314,150.171,10.000},
				{1314.439,151.250,10.000},
				{1329.673,152.339,10.000},
				{1345.016,153.437,10.000},
				{1360.471,154.544,10.000},
				{1376.037,155.661,10.000},
				{1391.716,156.787,10.000},
				{1407.508,157.923,10.000},
				{1423.415,159.069,10.000},
				{1439.437,160.224,10.000},
				{1455.576,161.389,10.000},
				{1471.832,162.564,10.000},
				{1488.207,163.748,10.000},
				{1504.702,164.943,10.000},
				{1521.316,166.147,10.000},
				{1538.052,167.361,10.000},
				{1554.911,168.585,10.000},
				{1571.893,169.819,10.000},
				{1588.999,171.062,10.000},
				{1606.230,172.315,10.000},
				{1623.588,173.579,10.000},
				{1641.074,174.852,10.000},
				{1658.687,176.135,10.000},
				{1676.430,177.427,10.000},
				{1694.303,178.730,10.000},
				{1712.307,180.042,10.000},
				{1730.443,181.363,10.000},
				{1748.713,182.695,10.000},
				{1767.116,184.036,10.000},
				{1785.643,185.270,10.000},
				{1804.271,186.278,10.000},
				{1822.977,187.060,10.000},
				{1841.738,187.612,10.000},
				{1860.543,188.050,10.000},
				{1879.392,188.490,10.000},
				{1898.285,188.932,10.000},
				{1917.223,189.377,10.000},
				{1936.205,189.823,10.000},
				{1955.232,190.271,10.000},
				{1974.305,190.721,10.000},
				{1993.422,191.172,10.000},
				{2012.584,191.624,10.000},
				{2031.792,192.078,10.000},
				{2051.045,192.532,10.000},
				{2070.344,192.988,10.000},
				{2089.688,193.444,10.000},
				{2109.078,193.900,10.000},
				{2128.514,194.357,10.000},
				{2147.995,194.814,10.000},
				{2167.522,195.271,10.000},
				{2187.095,195.728,10.000},
				{2206.714,196.185,10.000},
				{2226.378,196.642,10.000},
				{2246.088,197.098,10.000},
				{2265.843,197.553,10.000},
				{2285.644,198.008,10.000},
				{2305.490,198.462,10.000},
				{2325.381,198.914,10.000},
				{2345.318,199.365,10.000},
				{2365.300,199.815,10.000},
				{2385.326,200.264,10.000},
				{2405.397,200.710,10.000},
				{2425.513,201.155,10.000},
				{2445.672,201.598,10.000},
				{2465.876,202.038,10.000},
				{2486.124,202.477,10.000},
				{2506.415,202.912,10.000},
				{2526.750,203.345,10.000},
				{2547.127,203.775,10.000},
				{2567.547,204.202,10.000},
				{2588.010,204.625,10.000},
				{2608.514,205.045,10.000},
				{2629.060,205.462,10.000},
				{2649.648,205.874,10.000},
				{2670.276,206.282,10.000},
				{2690.945,206.687,10.000},
				{2711.653,207.086,10.000},
				{2732.401,207.481,10.000},
				{2753.188,207.871,10.000},
				{2774.014,208.256,10.000},
				{2794.878,208.635,10.000},
				{2815.778,209.009,10.000},
				{2836.716,209.377,10.000},
				{2857.690,209.739,10.000},
				{2878.699,210.094,10.000},
				{2899.744,210.443,10.000},
				{2920.822,210.785,10.000},
				{2941.934,211.120,10.000},
				{2963.079,211.447,10.000},
				{2984.256,211.767,10.000},
				{3005.464,212.079,10.000},
				{3026.702,212.383,10.000},
				{3047.970,212.679,10.000},
				{3069.266,212.966,10.000},
				{3090.591,213.244,10.000},
				{3111.942,213.513,10.000},
				{3133.319,213.772,10.000},
				{3154.721,214.021,10.000},
				{3176.147,214.261,10.000},
				{3197.596,214.490,10.000},
				{3219.067,214.709,10.000},
				{3240.559,214.916,10.000},
				{3262.070,215.113,10.000},
				{3283.600,215.299,10.000},
				{3305.147,215.472,10.000},
				{3326.711,215.634,10.000},
				{3348.289,215.784,10.000},
				{3369.881,215.921,10.000},
				{3391.486,216.046,10.000},
				{3413.102,216.158,10.000},
				{3434.727,216.257,10.000},
				{3456.362,216.343,10.000},
				{3478.003,216.415,10.000},
				{3499.650,216.473,10.000},
				{3521.302,216.517,10.000},
				{3542.957,216.547,10.000},
				{3564.613,216.563,10.000},
				{3586.270,216.564,10.000},
				{3607.925,216.550,10.000},
				{3629.577,216.522,10.000},
				{3651.225,216.478,10.000},
				{3672.867,216.419,10.000},
				{3694.501,216.345,10.000},
				{3716.126,216.255,10.000},
				{3737.741,216.149,10.000},
				{3759.344,216.027,10.000},
				{3780.933,215.890,10.000},
				{3802.507,215.736,10.000},
				{3824.063,215.566,10.000},
				{3845.601,215.380,10.000},
				{3867.119,215.177,10.000},
				{3888.615,214.958,10.000},
				{3910.087,214.722,10.000},
				{3931.534,214.469,10.000},
				{3952.954,214.200,10.000},
				{3974.345,213.914,10.000},
				{3995.706,213.610,10.000},
				{4017.035,213.290,10.000},
				{4038.331,212.952,10.000},
				{4059.590,212.598,10.000},
				{4080.813,212.225,10.000},
				{4101.996,211.836,10.000},
				{4123.139,211.429,10.000},
				{4144.240,211.005,10.000},
				{4165.296,210.563,10.000},
				{4186.306,210.103,10.000},
				{4207.269,209.626,10.000},
				{4228.182,209.130,10.000},
				{4249.044,208.617,10.000},
				{4269.852,208.086,10.000},
				{4290.606,207.536,10.000},
				{4311.303,206.968,10.000},
				{4331.941,206.381,10.000},
				{4352.518,205.776,10.000},
				{4373.034,205.152,10.000},
				{4393.485,204.509,10.000},
				{4413.869,203.847,10.000},
				{4434.186,203.166,10.000},
				{4454.432,202.465,10.000},
				{4474.607,201.744,10.000},
				{4494.707,201.003,10.000},
				{4514.731,200.242,10.000},
				{4534.677,199.460,10.000},
				{4554.543,198.657,10.000},
				{4574.326,197.833,10.000},
				{4594.025,196.987,10.000},
				{4613.637,196.120,10.000},
				{4633.172,195.351,10.000},
				{4652.786,196.136,10.000},
				{4672.525,197.393,10.000},
				{4692.389,198.639,10.000},
				{4712.377,199.879,10.000},
				{4732.488,201.114,10.000},
				{4752.723,202.347,10.000},
				{4773.081,203.579,10.000},
				{4793.562,204.814,10.000},
				{4814.168,206.054,10.000},
				{4834.897,207.300,10.000},
				{4855.753,208.555,10.000},
				{4876.735,209.821,10.000},
				{4897.845,211.100,10.000},
				{4919.085,212.395,10.000},
				{4940.455,213.708,10.000},
				{4961.959,215.041,10.000},
				{4983.599,216.395,10.000},
				{5005.376,217.775,10.000},
				{5027.295,219.181,10.000},
				{5049.356,220.617,10.000},
				{5071.565,222.084,10.000},
				{5093.923,223.585,10.000},
				{5116.435,225.123,10.000},
				{5139.105,226.700,10.000},
				{5161.937,228.319,10.000},
				{5184.936,229.983,10.000},
				{5208.105,231.693,10.000},
				{5231.450,233.454,10.000},
				{5254.977,235.267,10.000},
				{5278.691,237.136,10.000},
				{5302.597,239.064,10.000},
				{5326.702,241.053,10.000},
				{5351.013,243.105,10.000},
				{5375.535,245.225,10.000},
				{5400.277,247.414,10.000},
				{5425.244,249.676,10.000},
				{5450.446,252.012,10.000},
				{5475.888,254.425,10.000},
				{5501.568,256.800,10.000},
				{5527.465,258.971,10.000},
				{5553.554,260.882,10.000},
				{5579.806,262.520,10.000},
				{5606.205,263.991,10.000},
				{5632.750,265.456,10.000},
				{5659.446,266.954,10.000},
				{5686.294,268.483,10.000},
				{5713.298,270.037,10.000},
				{5740.459,271.612,10.000},
				{5767.779,273.200,10.000},
				{5795.258,274.794,10.000},
				{5822.897,276.387,10.000},
				{5850.694,277.968,10.000},
				{5878.646,279.527,10.000},
				{5906.752,281.052,10.000},
				{5935.005,282.533,10.000},
				{5963.400,283.955,10.000},
				{5991.931,285.304,10.000},
				{6020.588,286.567,10.000},
				{6049.360,287.727,10.000},
				{6078.237,288.771,10.000},
				{6107.206,289.682,10.000},
				{6136.250,290.445,10.000},
				{6165.355,291.046,10.000},
				{6194.502,291.472,10.000},
				{6223.673,291.709,10.000},
				{6252.847,291.745,10.000},
				{6282.005,291.573,10.000},
				{6311.123,291.183,10.000},
				{6340.180,290.569,10.000},
				{6369.153,289.730,10.000},
				{6398.019,288.662,10.000},
				{6426.756,287.368,10.000},
				{6455.341,285.851,10.000},
				{6483.753,284.117,10.000},
				{6511.970,282.174,10.000},
				{6539.973,280.032,10.000},
				{6567.743,277.701,10.000},
				{6595.263,275.196,10.000},
				{6622.516,272.530,10.000},
				{6649.488,269.717,10.000},
				{6676.165,266.774,10.000},
				{6702.537,263.716,10.000},
				{6728.593,260.559,10.000},
				{6754.324,257.317,10.000},
				{6779.725,254.005,10.000},
				{6804.789,250.639,10.000},
				{6829.512,247.231,10.000},
				{6853.891,243.795,10.000},
				{6877.925,240.341,10.000},
				{6901.614,236.881,10.000},
				{6924.956,233.424,10.000},
				{6947.954,229.980,10.000},
				{6970.610,226.555,10.000},
				{6992.925,223.157,10.000},
				{7014.904,219.792,10.000},
				{7036.551,216.464,10.000},
				{7057.869,213.178,10.000},
				{7078.862,209.938,10.000},
				{7099.537,206.746,10.000},
				{7119.897,203.604,10.000},
				{7139.949,200.515,10.000},
				{7159.697,197.480,10.000},
				{7179.147,194.499,10.000},
				{7198.304,191.573,10.000},
				{7217.174,188.702,10.000},
				{7235.763,185.887,10.000},
				{7254.076,183.125,10.000},
				{7272.117,180.417,10.000},
				{7289.894,177.763,10.000},
				{7307.410,175.161,10.000},
				{7324.671,172.610,10.000},
				{7341.682,170.108,10.000},
				{7358.447,167.656,10.000},
				{7374.972,165.252,10.000},
				{7391.262,162.893,10.000},
				{7407.320,160.580,10.000},
				{7423.151,158.310,10.000},
				{7438.759,156.083,10.000},
				{7454.148,153.896,10.000},
				{7469.323,151.749,10.000},
				{7484.287,149.641,10.000},
				{7499.044,147.569,10.000},
				{7513.598,145.533,10.000},
				{7527.951,143.532,10.000},
				{7542.107,141.564,10.000},
				{7556.070,139.629,10.000},
				{7569.843,137.724,10.000},
				{7583.428,135.849,10.000},
				{7596.828,134.004,10.000},
				{7610.047,132.186,10.000},
				{7623.086,130.394,10.000},
				{7635.949,128.629,10.000},
				{7648.638,126.889,10.000},
				{7661.155,125.172,10.000},
				{7673.503,123.479,10.000},
				{7685.684,121.809,10.000},
				{7697.700,120.160,10.000},
				{7709.553,118.531,10.000},
				{7721.245,116.923,10.000},
				{7732.779,115.334,10.000},
				{7744.155,113.764,10.000},
				{7755.376,112.212,10.000},
				{7766.444,110.678,10.000},
				{7777.360,109.160,10.000},
				{7788.126,107.659,10.000},
				{7798.743,106.173,10.000},
				{7809.214,104.703,10.000},
				{7819.538,103.247,10.000},
				{7829.719,101.806,10.000},
				{7839.757,100.379,10.000},
				{7849.653,98.965,10.000},
				{7859.410,97.564,10.000},
				{7869.027,96.175,10.000},
				{7878.507,94.799,10.000},
				{7887.850,93.434,10.000},
				{7897.059,92.081,10.000},
				{7906.132,90.739,10.000},
				{7915.073,89.408,10.000},
				{7923.882,88.087,10.000},
				{7932.560,86.776,10.000},
				{7941.107,85.476,10.000},
				{7949.526,84.185,10.000},
				{7957.816,82.903,10.000},
				{7965.979,81.630,10.000},
				{7974.016,80.367,10.000},
				{7981.927,79.111,10.000},
				{7989.713,77.865,10.000},
				{7997.376,76.626,10.000},
				{8004.915,75.396,10.000},
				{8012.333,74.173,10.000},
				{8019.628,72.958,10.000},
				{8026.803,71.750,10.000},
				{8033.858,70.550,10.000},
				{8040.794,69.356,10.000},
				{8047.611,68.170,10.000},
				{8054.310,66.990,10.000},
				{8060.892,65.817,10.000},
				{8067.357,64.650,10.000},
				{8073.706,63.489,10.000},
				{8079.939,62.335,10.000},
				{8086.058,61.187,10.000},
				{8092.062,60.044,10.000},
				{8097.953,58.907,10.000},
				{8103.731,57.776,10.000},
				{8109.396,56.651,10.000},
				{8114.949,55.530,10.000},
				{8120.390,54.415,10.000},
				{8125.721,53.306,10.000},
				{8130.941,52.201,10.000},
				{8136.051,51.101,10.000},
				{8141.052,50.006,10.000},
				{8145.943,48.916,10.000},
				{8150.726,47.830,10.000},
				{8155.401,46.749,10.000},
				{8159.968,45.672,10.000},
				{8164.428,44.600,10.000},
				{8168.781,43.532,10.000},
				{8173.028,42.467,10.000},
				{8177.169,41.407,10.000},
				{8181.204,40.351,10.000},
				{8185.134,39.299,10.000},
				{8188.959,38.251,10.000},
				{8192.680,37.206,10.000},
				{8196.296,36.164,10.000},
				{8199.809,35.127,10.000},
				{8203.218,34.092,10.000},
				{8206.524,33.061,10.000},
				{8209.727,32.033,10.000},
				{8212.828,31.008,10.000},
				{8215.827,29.986,10.000},
				{8218.723,28.967,10.000},
				{8221.519,27.951,10.000},
				{8224.212,26.938,10.000},
				{8226.805,25.927,10.000},
				{8229.297,24.919,10.000},
				{8231.688,23.913,10.000},
				{8233.979,22.910,10.000},
				{8236.170,21.909,10.000},
				{8238.261,20.910,10.000},
				{8240.252,19.913,10.000},
				{8242.144,18.918,10.000},
				{8243.937,17.925,10.000},
				{8245.630,16.934,10.000},
				{8247.225,15.945,10.000},
				{8248.720,14.957,10.000},
				{8250.118,13.971,10.000},
				{8251.416,12.986,10.000},
				{8252.616,12.002,10.000},
				{8253.718,11.020,10.000},
				{8254.722,10.039,10.000},
				{8255.628,9.058,10.000},
				{8256.436,8.079,10.000},
				{8257.146,7.101,10.000},
				{8257.758,6.123,10.000},
				{8258.273,5.146,10.000},
				{8258.690,4.169,10.000},
				{8259.009,3.193,10.000},
				{8259.231,2.217,10.000},
				{8259.364,1.330,10.000},
				{8259.429,0.654,10.000},
				{8259.452,0.222,10.000},
				{8259.455,0.033,10.000},
				{8259.455,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.012,0.244,10.000},
				{0.061,0.488,10.000},
				{0.171,1.097,10.000},
				{0.366,1.951,10.000},
				{0.658,2.927,10.000},
				{1.049,3.902,10.000},
				{1.537,4.879,10.000},
				{2.122,5.855,10.000},
				{2.805,6.832,10.000},
				{3.586,7.809,10.000},
				{4.465,8.787,10.000},
				{5.441,9.765,10.000},
				{6.516,10.745,10.000},
				{7.688,11.724,10.000},
				{8.959,12.705,10.000},
				{10.327,13.687,10.000},
				{11.794,14.669,10.000},
				{13.360,15.653,10.000},
				{15.023,16.637,10.000},
				{16.786,17.623,10.000},
				{18.647,18.610,10.000},
				{20.606,19.598,10.000},
				{22.665,20.587,10.000},
				{24.823,21.578,10.000},
				{27.080,22.570,10.000},
				{29.436,23.564,10.000},
				{31.892,24.559,10.000},
				{34.448,25.556,10.000},
				{37.103,26.554,10.000},
				{39.858,27.554,10.000},
				{42.714,28.556,10.000},
				{45.670,29.559,10.000},
				{48.726,30.565,10.000},
				{51.884,31.572,10.000},
				{55.142,32.582,10.000},
				{58.501,33.593,10.000},
				{61.962,34.606,10.000},
				{65.524,35.622,10.000},
				{69.188,36.639,10.000},
				{72.954,37.659,10.000},
				{76.822,38.681,10.000},
				{80.792,39.705,10.000},
				{84.865,40.731,10.000},
				{89.042,41.760,10.000},
				{93.321,42.791,10.000},
				{97.703,43.825,10.000},
				{102.189,44.861,10.000},
				{106.779,45.899,10.000},
				{111.473,46.940,10.000},
				{116.271,47.983,10.000},
				{121.174,49.029,10.000},
				{126.182,50.077,10.000},
				{131.295,51.128,10.000},
				{136.513,52.182,10.000},
				{141.837,53.238,10.000},
				{147.267,54.297,10.000},
				{152.802,55.358,10.000},
				{158.445,56.422,10.000},
				{164.193,57.489,10.000},
				{170.049,58.558,10.000},
				{176.012,59.630,10.000},
				{182.083,60.705,10.000},
				{188.261,61.782,10.000},
				{194.547,62.862,10.000},
				{200.942,63.945,10.000},
				{207.445,65.030,10.000},
				{214.056,66.118,10.000},
				{220.777,67.209,10.000},
				{227.608,68.302,10.000},
				{234.547,69.398,10.000},
				{241.597,70.497,10.000},
				{248.757,71.598,10.000},
				{256.027,72.702,10.000},
				{263.408,73.809,10.000},
				{270.900,74.918,10.000},
				{278.503,76.029,10.000},
				{286.217,77.143,10.000},
				{294.043,78.260,10.000},
				{301.981,79.379,10.000},
				{310.031,80.500,10.000},
				{318.193,81.624,10.000},
				{326.468,82.750,10.000},
				{334.856,83.878,10.000},
				{343.357,85.009,10.000},
				{351.971,86.141,10.000},
				{360.699,87.276,10.000},
				{369.540,88.414,10.000},
				{378.495,89.553,10.000},
				{387.565,90.694,10.000},
				{396.748,91.837,10.000},
				{406.047,92.982,10.000},
				{415.459,94.129,10.000},
				{424.987,95.277,10.000},
				{434.630,96.427,10.000},
				{444.388,97.579,10.000},
				{454.261,98.733,10.000},
				{464.250,99.888,10.000},
				{474.354,101.044,10.000},
				{484.574,102.201,10.000},
				{494.910,103.360,10.000},
				{505.362,104.520,10.000},
				{515.930,105.681,10.000},
				{526.615,106.843,10.000},
				{537.415,108.006,10.000},
				{548.332,109.169,10.000},
				{559.366,110.333,10.000},
				{570.515,111.498,10.000},
				{581.782,112.663,10.000},
				{593.164,113.828,10.000},
				{604.664,114.994,10.000},
				{616.280,116.160,10.000},
				{628.012,117.325,10.000},
				{639.861,118.491,10.000},
				{651.827,119.656,10.000},
				{663.909,120.821,10.000},
				{676.108,121.985,10.000},
				{688.423,123.149,10.000},
				{700.854,124.312,10.000},
				{713.401,125.474,10.000},
				{726.065,126.635,10.000},
				{738.844,127.794,10.000},
				{751.739,128.953,10.000},
				{764.750,130.109,10.000},
				{777.877,131.264,10.000},
				{791.119,132.418,10.000},
				{804.476,133.569,10.000},
				{817.947,134.718,10.000},
				{831.534,135.865,10.000},
				{845.235,137.009,10.000},
				{859.050,138.151,10.000},
				{872.979,139.290,10.000},
				{887.021,140.425,10.000},
				{901.177,141.558,10.000},
				{915.446,142.688,10.000},
				{929.827,143.814,10.000},
				{944.321,144.936,10.000},
				{958.926,146.054,10.000},
				{973.643,147.169,10.000},
				{988.471,148.279,10.000},
				{1003.409,149.385,10.000},
				{1018.458,150.486,10.000},
				{1033.616,151.583,10.000},
				{1048.884,152.675,10.000},
				{1064.260,153.761,10.000},
				{1079.744,154.843,10.000},
				{1095.336,155.919,10.000},
				{1111.035,156.990,10.000},
				{1126.841,158.054,10.000},
				{1142.752,159.113,10.000},
				{1158.768,160.166,10.000},
				{1174.890,161.212,10.000},
				{1191.115,162.252,10.000},
				{1207.443,163.285,10.000},
				{1223.875,164.312,10.000},
				{1240.408,165.332,10.000},
				{1257.042,166.344,10.000},
				{1273.777,167.349,10.000},
				{1290.612,168.347,10.000},
				{1307.546,169.338,10.000},
				{1324.578,170.321,10.000},
				{1341.707,171.295,10.000},
				{1358.933,172.262,10.000},
				{1376.256,173.221,10.000},
				{1393.673,174.172,10.000},
				{1411.184,175.114,10.000},
				{1428.789,176.048,10.000},
				{1446.486,176.973,10.000},
				{1464.275,177.889,10.000},
				{1482.155,178.797,10.000},
				{1500.124,179.696,10.000},
				{1518.183,180.586,10.000},
				{1536.330,181.466,10.000},
				{1554.563,182.338,10.000},
				{1572.883,183.200,10.000},
				{1591.289,184.053,10.000},
				{1609.778,184.896,10.000},
				{1628.351,185.730,10.000},
				{1647.007,186.555,10.000},
				{1665.744,187.369,10.000},
				{1684.561,188.175,10.000},
				{1703.458,188.970,10.000},
				{1722.434,189.756,10.000},
				{1741.487,190.532,10.000},
				{1760.617,191.298,10.000},
				{1779.822,192.055,10.000},
				{1799.102,192.801,10.000},
				{1818.456,193.538,10.000},
				{1837.883,194.265,10.000},
				{1857.381,194.982,10.000},
				{1876.950,195.690,10.000},
				{1896.589,196.387,10.000},
				{1916.296,197.074,10.000},
				{1936.071,197.752,10.000},
				{1955.913,198.420,10.000},
				{1975.821,199.078,10.000},
				{1995.794,199.727,10.000},
				{2015.830,200.366,10.000},
				{2035.930,200.995,10.000},
				{2056.091,201.614,10.000},
				{2076.314,202.224,10.000},
				{2096.583,202.697,10.000},
				{2116.874,202.907,10.000},
				{2137.160,202.857,10.000},
				{2157.415,202.549,10.000},
				{2177.626,202.112,10.000},
				{2197.793,201.671,10.000},
				{2217.916,201.229,10.000},
				{2237.994,200.785,10.000},
				{2258.028,200.338,10.000},
				{2278.017,199.890,10.000},
				{2297.961,199.441,10.000},
				{2317.860,198.989,10.000},
				{2337.714,198.537,10.000},
				{2357.522,198.084,10.000},
				{2377.285,197.629,10.000},
				{2397.003,197.174,10.000},
				{2416.674,196.718,10.000},
				{2436.301,196.261,10.000},
				{2455.881,195.804,10.000},
				{2475.416,195.347,10.000},
				{2494.905,194.890,10.000},
				{2514.348,194.433,10.000},
				{2533.746,193.976,10.000},
				{2553.098,193.520,10.000},
				{2572.404,193.063,10.000},
				{2591.665,192.608,10.000},
				{2610.880,192.153,10.000},
				{2630.050,191.700,10.000},
				{2649.175,191.247,10.000},
				{2668.254,190.796,10.000},
				{2687.289,190.346,10.000},
				{2706.279,189.898,10.000},
				{2725.224,189.451,10.000},
				{2744.125,189.006,10.000},
				{2762.981,188.563,10.000},
				{2781.793,188.123,10.000},
				{2800.562,187.685,10.000},
				{2819.287,187.249,10.000},
				{2837.968,186.816,10.000},
				{2856.607,186.386,10.000},
				{2875.203,185.960,10.000},
				{2893.756,185.536,10.000},
				{2912.268,185.116,10.000},
				{2930.738,184.700,10.000},
				{2949.167,184.287,10.000},
				{2967.555,183.879,10.000},
				{2985.902,183.475,10.000},
				{3004.210,183.075,10.000},
				{3022.478,182.680,10.000},
				{3040.707,182.290,10.000},
				{3058.897,181.906,10.000},
				{3077.050,181.526,10.000},
				{3095.165,181.152,10.000},
				{3113.243,180.784,10.000},
				{3131.286,180.423,10.000},
				{3149.292,180.067,10.000},
				{3167.264,179.718,10.000},
				{3185.202,179.376,10.000},
				{3203.106,179.041,10.000},
				{3220.977,178.714,10.000},
				{3238.817,178.394,10.000},
				{3256.625,178.082,10.000},
				{3274.403,177.778,10.000},
				{3292.151,177.482,10.000},
				{3309.871,177.195,10.000},
				{3327.562,176.917,10.000},
				{3345.227,176.649,10.000},
				{3362.866,176.389,10.000},
				{3380.480,176.140,10.000},
				{3398.070,175.900,10.000},
				{3415.637,175.671,10.000},
				{3433.182,175.453,10.000},
				{3450.707,175.245,10.000},
				{3468.212,175.048,10.000},
				{3485.698,174.863,10.000},
				{3503.167,174.689,10.000},
				{3520.620,174.527,10.000},
				{3538.057,174.377,10.000},
				{3555.481,174.240,10.000},
				{3572.893,174.115,10.000},
				{3590.293,174.003,10.000},
				{3607.683,173.904,10.000},
				{3625.065,173.818,10.000},
				{3642.440,173.746,10.000},
				{3659.809,173.688,10.000},
				{3677.173,173.644,10.000},
				{3694.535,173.614,10.000},
				{3711.894,173.598,10.000},
				{3729.254,173.597,10.000},
				{3746.615,173.611,10.000},
				{3763.979,173.639,10.000},
				{3781.347,173.683,10.000},
				{3798.722,173.742,10.000},
				{3816.103,173.816,10.000},
				{3833.494,173.906,10.000},
				{3850.895,174.012,10.000},
				{3868.308,174.134,10.000},
				{3885.736,174.271,10.000},
				{3903.178,174.425,10.000},
				{3920.638,174.595,10.000},
				{3938.116,174.781,10.000},
				{3955.614,174.984,10.000},
				{3973.134,175.203,10.000},
				{3990.678,175.439,10.000},
				{4008.248,175.692,10.000},
				{4025.844,175.961,10.000},
				{4043.468,176.248,10.000},
				{4061.123,176.551,10.000},
				{4078.811,176.871,10.000},
				{4096.532,177.209,10.000},
				{4114.288,177.564,10.000},
				{4132.081,177.936,10.000},
				{4149.914,178.325,10.000},
				{4167.787,178.732,10.000},
				{4185.703,179.156,10.000},
				{4203.663,179.598,10.000},
				{4221.668,180.058,10.000},
				{4239.722,180.536,10.000},
				{4257.825,181.031,10.000},
				{4275.979,181.544,10.000},
				{4294.187,182.076,10.000},
				{4312.450,182.625,10.000},
				{4330.769,183.193,10.000},
				{4349.147,183.780,10.000},
				{4367.585,184.385,10.000},
				{4386.086,185.009,10.000},
				{4404.652,185.652,10.000},
				{4423.283,186.314,10.000},
				{4441.983,186.996,10.000},
				{4460.752,187.697,10.000},
				{4479.594,188.418,10.000},
				{4498.510,189.159,10.000},
				{4517.502,189.920,10.000},
				{4536.572,190.702,10.000},
				{4555.722,191.504,10.000},
				{4574.955,192.328,10.000},
				{4594.273,193.174,10.000},
				{4613.677,194.041,10.000},
				{4633.158,194.810,10.000},
				{4652.560,194.025,10.000},
				{4671.837,192.769,10.000},
				{4690.989,191.522,10.000},
				{4710.018,190.282,10.000},
				{4728.922,189.047,10.000},
				{4747.704,187.815,10.000},
				{4766.362,186.582,10.000},
				{4784.897,185.347,10.000},
				{4803.307,184.108,10.000},
				{4821.594,182.861,10.000},
				{4839.754,181.606,10.000},
				{4857.788,180.340,10.000},
				{4875.694,179.061,10.000},
				{4893.471,177.766,10.000},
				{4911.116,176.453,10.000},
				{4928.628,175.121,10.000},
				{4946.005,173.766,10.000},
				{4963.244,172.386,10.000},
				{4980.342,170.980,10.000},
				{4997.296,169.544,10.000},
				{5014.104,168.077,10.000},
				{5030.761,166.576,10.000},
				{5047.265,165.038,10.000},
				{5063.611,163.461,10.000},
				{5079.795,161.842,10.000},
				{5095.813,160.178,10.000},
				{5111.660,158.467,10.000},
				{5127.331,156.707,10.000},
				{5142.820,154.893,10.000},
				{5158.122,153.024,10.000},
				{5173.232,151.096,10.000},
				{5188.143,149.108,10.000},
				{5202.848,147.055,10.000},
				{5217.342,144.935,10.000},
				{5231.616,142.746,10.000},
				{5245.665,140.484,10.000},
				{5259.479,138.148,10.000},
				{5273.053,135.734,10.000},
				{5286.371,133.182,10.000},
				{5299.412,130.413,10.000},
				{5312.154,127.415,10.000},
				{5324.574,124.204,10.000},
				{5336.659,120.848,10.000},
				{5348.402,117.432,10.000},
				{5359.800,113.983,10.000},
				{5370.851,110.503,10.000},
				{5381.551,106.998,10.000},
				{5391.898,103.472,10.000},
				{5401.891,99.933,10.000},
				{5411.530,96.388,10.000},
				{5420.814,92.845,10.000},
				{5429.746,89.313,10.000},
				{5438.326,85.803,10.000},
				{5446.559,82.326,10.000},
				{5454.448,78.894,10.000},
				{5462.000,75.521,10.000},
				{5469.222,72.221,10.000},
				{5476.123,69.007,10.000},
				{5482.713,65.896,10.000},
				{5489.003,62.901,10.000},
				{5495.007,60.040,10.000},
				{5500.739,57.325,10.000},
				{5506.216,54.773,10.000},
				{5511.456,52.397,10.000},
				{5516.477,50.209,10.000},
				{5521.299,48.221,10.000},
				{5525.943,46.443,10.000},
				{5530.432,44.882,10.000},
				{5534.786,43.545,10.000},
				{5539.030,42.434,10.000},
				{5543.185,41.551,10.000},
				{5547.274,40.894,10.000},
				{5551.320,40.460,10.000},
				{5555.344,40.243,10.000},
				{5559.368,40.236,10.000},
				{5563.411,40.428,10.000},
				{5567.491,40.807,10.000},
				{5571.628,41.362,10.000},
				{5575.835,42.078,10.000},
				{5580.129,42.939,10.000},
				{5584.522,43.932,10.000},
				{5589.026,45.039,10.000},
				{5593.651,46.246,10.000},
				{5598.405,47.538,10.000},
				{5603.295,48.898,10.000},
				{5608.326,50.314,10.000},
				{5613.503,51.771,10.000},
				{5618.829,53.257,10.000},
				{5624.305,54.760,10.000},
				{5629.932,56.269,10.000},
				{5635.709,57.776,10.000},
				{5641.636,59.270,10.000},
				{5647.711,60.744,10.000},
				{5653.930,62.191,10.000},
				{5660.290,63.606,10.000},
				{5666.789,64.983,10.000},
				{5673.420,66.318,10.000},
				{5680.181,67.608,10.000},
				{5687.066,68.849,10.000},
				{5694.070,70.040,10.000},
				{5701.188,71.178,10.000},
				{5708.414,72.263,10.000},
				{5715.743,73.293,10.000},
				{5723.170,74.268,10.000},
				{5730.689,75.188,10.000},
				{5738.294,76.053,10.000},
				{5745.981,76.864,10.000},
				{5753.743,77.621,10.000},
				{5761.575,78.325,10.000},
				{5769.473,78.976,10.000},
				{5777.430,79.576,10.000},
				{5785.443,80.127,10.000},
				{5793.506,80.628,10.000},
				{5801.614,81.082,10.000},
				{5809.763,81.490,10.000},
				{5817.948,81.852,10.000},
				{5826.165,82.171,10.000},
				{5834.410,82.448,10.000},
				{5842.679,82.684,10.000},
				{5850.967,82.880,10.000},
				{5859.270,83.038,10.000},
				{5867.586,83.158,10.000},
				{5875.911,83.243,10.000},
				{5884.240,83.294,10.000},
				{5892.571,83.311,10.000},
				{5900.901,83.296,10.000},
				{5909.226,83.249,10.000},
				{5917.543,83.173,10.000},
				{5925.850,83.068,10.000},
				{5934.143,82.936,10.000},
				{5942.421,82.776,10.000},
				{5950.680,82.591,10.000},
				{5958.918,82.380,10.000},
				{5967.132,82.146,10.000},
				{5975.321,81.888,10.000},
				{5983.482,81.608,10.000},
				{5991.613,81.306,10.000},
				{5999.711,80.984,10.000},
				{6007.775,80.641,10.000},
				{6015.803,80.279,10.000},
				{6023.793,79.898,10.000},
				{6031.743,79.499,10.000},
				{6039.651,79.083,10.000},
				{6047.516,78.650,10.000},
				{6055.336,78.200,10.000},
				{6063.110,77.735,10.000},
				{6070.835,77.255,10.000},
				{6078.511,76.759,10.000},
				{6086.136,76.250,10.000},
				{6093.709,75.726,10.000},
				{6101.228,75.190,10.000},
				{6108.692,74.640,10.000},
				{6116.099,74.078,10.000},
				{6123.450,73.503,10.000},
				{6130.741,72.917,10.000},
				{6137.973,72.319,10.000},
				{6145.144,71.711,10.000},
				{6152.254,71.091,10.000},
				{6159.300,70.461,10.000},
				{6166.282,69.821,10.000},
				{6173.199,69.171,10.000},
				{6180.050,68.511,10.000},
				{6186.834,67.842,10.000},
				{6193.550,67.164,10.000},
				{6200.198,66.477,10.000},
				{6206.776,65.781,10.000},
				{6213.284,65.077,10.000},
				{6219.720,64.364,10.000},
				{6226.085,63.644,10.000},
				{6232.376,62.916,10.000},
				{6238.594,62.180,10.000},
				{6244.738,61.437,10.000},
				{6250.807,60.687,10.000},
				{6256.800,59.930,10.000},
				{6262.716,59.165,10.000},
				{6268.556,58.394,10.000},
				{6274.317,57.617,10.000},
				{6280.001,56.833,10.000},
				{6285.605,56.042,10.000},
				{6291.129,55.246,10.000},
				{6296.574,54.444,10.000},
				{6301.937,53.635,10.000},
				{6307.219,52.821,10.000},
				{6312.420,52.002,10.000},
				{6317.537,51.176,10.000},
				{6322.572,50.346,10.000},
				{6327.523,49.510,10.000},
				{6332.390,48.669,10.000},
				{6337.172,47.823,10.000},
				{6341.869,46.972,10.000},
				{6346.481,46.116,10.000},
				{6351.006,45.256,10.000},
				{6355.445,44.390,10.000},
				{6359.797,43.521,10.000},
				{6364.062,42.647,10.000},
				{6368.239,41.768,10.000},
				{6372.328,40.886,10.000},
				{6376.327,39.999,10.000},
				{6380.238,39.108,10.000},
				{6384.060,38.214,10.000},
				{6387.791,37.315,10.000},
				{6391.432,36.413,10.000},
				{6394.983,35.507,10.000},
				{6398.443,34.597,10.000},
				{6401.811,33.684,10.000},
				{6405.088,32.768,10.000},
				{6408.273,31.848,10.000},
				{6411.365,30.925,10.000},
				{6414.365,30.000,10.000},
				{6417.272,29.071,10.000},
				{6420.086,28.139,10.000},
				{6422.807,27.204,10.000},
				{6425.433,26.267,10.000},
				{6427.966,25.326,10.000},
				{6430.404,24.384,10.000},
				{6432.748,23.439,10.000},
				{6434.997,22.491,10.000},
				{6437.152,21.542,10.000},
				{6439.211,20.590,10.000},
				{6441.174,19.636,10.000},
				{6443.042,18.680,10.000},
				{6444.814,17.722,10.000},
				{6446.490,16.762,10.000},
				{6448.071,15.801,10.000},
				{6449.554,14.838,10.000},
				{6450.942,13.873,10.000},
				{6452.232,12.907,10.000},
				{6453.426,11.940,10.000},
				{6454.523,10.972,10.000},
				{6455.524,10.002,10.000},
				{6456.427,9.031,10.000},
				{6457.233,8.060,10.000},
				{6457.942,7.088,10.000},
				{6458.553,6.114,10.000},
				{6459.067,5.141,10.000},
				{6459.484,4.167,10.000},
				{6459.803,3.192,10.000},
				{6460.025,2.217,10.000},
				{6460.158,1.330,10.000},
				{6460.223,0.654,10.000},
				{6460.245,0.222,10.000},
				{6460.249,0.033,10.000},
				{6460.249,0.000,10.000}
		};
		
		if (flipped) {
			rightProfile = new SrxMotionProfile(leftPoints.length, leftPoints);
			leftProfile = new SrxMotionProfile(rightPoints.length, rightPoints);
		} else {
			leftProfile = new SrxMotionProfile(leftPoints.length, leftPoints);
			rightProfile = new SrxMotionProfile(rightPoints.length, rightPoints);
		}
	}

}