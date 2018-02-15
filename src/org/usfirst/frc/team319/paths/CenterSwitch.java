package org.usfirst.frc.team319.paths;

import org.usfirst.frc.team319.models.SrxMotionProfile;
import org.usfirst.frc.team319.models.SrxTrajectory;

public class CenterSwitch extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (2.75,0.00,0.00)
	// (11.67,5.00,0.00)
	
	public CenterSwitch() {
		this(false);
	}
			
    public CenterSwitch(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{0.015,0.300,10.000},
				{0.075,0.599,10.000},
				{0.210,1.348,10.000},
				{0.449,2.397,10.000},
				{0.824,3.745,10.000},
				{1.363,5.391,10.000},
				{2.097,7.336,10.000},
				{3.054,9.579,10.000},
				{4.266,12.118,10.000},
				{5.761,14.952,10.000},
				{7.569,18.080,10.000},
				{9.719,21.500,10.000},
				{12.240,25.209,10.000},
				{15.161,29.205,10.000},
				{18.494,33.335,10.000},
				{22.239,37.449,10.000},
				{26.394,41.545,10.000},
				{30.956,45.620,10.000},
				{35.923,49.673,10.000},
				{41.293,53.702,10.000},
				{47.064,57.705,10.000},
				{53.231,61.680,10.000},
				{59.794,65.625,10.000},
				{66.748,69.540,10.000},
				{74.090,73.422,10.000},
				{81.817,77.269,10.000},
				{89.925,81.080,10.000},
				{98.410,84.853,10.000},
				{107.269,88.588,10.000},
				{116.497,92.281,10.000},
				{126.091,95.933,10.000},
				{136.045,99.540,10.000},
				{146.355,103.103,10.000},
				{157.017,106.619,10.000},
				{168.026,110.087,10.000},
				{179.376,113.506,10.000},
				{191.063,116.874,10.000},
				{203.082,120.189,10.000},
				{215.427,123.451,10.000},
				{228.093,126.657,10.000},
				{241.074,129.807,10.000},
				{254.364,132.899,10.000},
				{267.957,135.931,10.000},
				{281.847,138.901,10.000},
				{296.028,141.809,10.000},
				{310.493,144.653,10.000},
				{325.236,147.430,10.000},
				{340.250,150.140,10.000},
				{355.528,152.781,10.000},
				{371.063,155.350,10.000},
				{386.848,157.848,10.000},
				{402.875,160.271,10.000},
				{419.137,162.618,10.000},
				{435.626,164.889,10.000},
				{452.334,167.081,10.000},
				{469.253,169.193,10.000},
				{486.376,171.225,10.000},
				{503.693,173.175,10.000},
				{521.197,175.042,10.000},
				{538.880,176.827,10.000},
				{556.733,178.530,10.000},
				{574.748,180.151,10.000},
				{592.917,181.691,10.000},
				{611.233,183.153,10.000},
				{629.686,184.538,10.000},
				{648.271,185.850,10.000},
				{666.981,187.094,10.000},
				{685.808,188.275,10.000},
				{704.748,189.401,10.000},
				{723.796,190.478,10.000},
				{742.948,191.517,10.000},
				{762.201,192.530,10.000},
				{781.554,193.528,10.000},
				{801.006,194.528,10.000},
				{820.561,195.545,10.000},
				{840.221,196.598,10.000},
				{859.991,197.707,10.000},
				{879.881,198.895,10.000},
				{899.899,200.185,10.000},
				{920.060,201.601,10.000},
				{940.376,203.169,10.000},
				{960.868,204.915,10.000},
				{981.554,206.865,10.000},
				{1002.459,209.046,10.000},
				{1023.607,211.482,10.000},
				{1045.027,214.196,10.000},
				{1066.748,217.208,10.000},
				{1088.801,220.537,10.000},
				{1111.221,224.198,10.000},
				{1134.041,228.202,10.000},
				{1157.297,232.555,10.000},
				{1181.023,237.261,10.000},
				{1205.255,242.318,10.000},
				{1230.027,247.720,10.000},
				{1255.373,253.458,10.000},
				{1281.324,259.519,10.000},
				{1307.913,265.887,10.000},
				{1335.168,272.544,10.000},
				{1363.115,279.469,10.000},
				{1391.779,286.641,10.000},
				{1421.171,293.926,10.000},
				{1451.289,301.178,10.000},
				{1482.125,308.364,10.000},
				{1513.670,315.447,10.000},
				{1545.909,322.393,10.000},
				{1578.827,329.172,10.000},
				{1612.402,335.752,10.000},
				{1646.612,342.107,10.000},
				{1681.434,348.212,10.000},
				{1716.838,354.045,10.000},
				{1752.797,359.588,10.000},
				{1789.279,364.824,10.000},
				{1826.253,369.738,10.000},
				{1863.685,374.319,10.000},
				{1901.555,378.693,10.000},
				{1939.854,382.995,10.000},
				{1978.577,387.230,10.000},
				{2017.717,391.404,10.000},
				{2057.270,395.523,10.000},
				{2097.229,399.595,10.000},
				{2137.592,403.626,10.000},
				{2178.354,407.625,10.000},
				{2219.514,411.599,10.000},
				{2261.070,415.557,10.000},
				{2303.021,419.506,10.000},
				{2345.366,423.456,10.000},
				{2388.108,427.414,10.000},
				{2431.246,431.388,10.000},
				{2474.785,435.387,10.000},
				{2518.727,439.418,10.000},
				{2563.076,443.490,10.000},
				{2607.837,447.609,10.000},
				{2653.015,451.783,10.000},
				{2698.617,456.018,10.000},
				{2744.649,460.320,10.000},
				{2791.118,464.693,10.000},
				{2838.015,468.973,10.000},
				{2885.314,472.986,10.000},
				{2932.986,476.722,10.000},
				{2981.003,480.165,10.000},
				{3029.333,483.300,10.000},
				{3077.943,486.107,10.000},
				{3126.800,488.564,10.000},
				{3175.864,490.647,10.000},
				{3225.097,492.329,10.000},
				{3274.455,493.579,10.000},
				{3323.892,494.367,10.000},
				{3373.358,494.657,10.000},
				{3422.799,494.416,10.000},
				{3472.160,493.607,10.000},
				{3521.399,492.388,10.000},
				{3570.491,490.921,10.000},
				{3619.409,489.186,10.000},
				{3668.126,487.163,10.000},
				{3716.609,484.832,10.000},
				{3764.827,482.179,10.000},
				{3812.746,479.189,10.000},
				{3860.331,475.854,10.000},
				{3907.548,472.168,10.000},
				{3954.361,468.130,10.000},
				{4000.735,463.742,10.000},
				{4046.636,459.012,10.000},
				{4092.031,453.950,10.000},
				{4136.888,448.571,10.000},
				{4181.178,442.894,10.000},
				{4224.872,436.939,10.000},
				{4267.945,430.729,10.000},
				{4310.374,424.289,10.000},
				{4352.138,417.645,10.000},
				{4393.220,410.823,10.000},
				{4433.605,403.849,10.000},
				{4473.280,396.748,10.000},
				{4512.235,389.546,10.000},
				{4550.461,382.266,10.000},
				{4587.954,374.929,10.000},
				{4624.710,367.557,10.000},
				{4660.727,360.167,10.000},
				{4696.004,352.776,10.000},
				{4730.544,345.399,10.000},
				{4764.349,338.049,10.000},
				{4797.423,330.737,10.000},
				{4829.770,323.472,10.000},
				{4861.396,316.264,10.000},
				{4892.308,309.119,10.000},
				{4922.512,302.042,10.000},
				{4952.016,295.038,10.000},
				{4980.827,288.110,10.000},
				{5008.953,281.261,10.000},
				{5036.402,274.492,10.000},
				{5063.183,267.806,10.000},
				{5089.303,261.201,10.000},
				{5114.771,254.680,10.000},
				{5139.595,248.240,10.000},
				{5163.783,241.882,10.000},
				{5187.344,235.605,10.000},
				{5210.285,229.407,10.000},
				{5232.613,223.288,10.000},
				{5254.338,217.246,10.000},
				{5275.466,211.280,10.000},
				{5296.005,205.388,10.000},
				{5315.962,199.568,10.000},
				{5335.344,193.819,10.000},
				{5354.158,188.139,10.000},
				{5372.410,182.527,10.000},
				{5390.108,176.981,10.000},
				{5407.258,171.499,10.000},
				{5423.866,166.081,10.000},
				{5439.939,160.723,10.000},
				{5455.481,155.425,10.000},
				{5470.500,150.185,10.000},
				{5485.000,145.002,10.000},
				{5498.987,139.874,10.000},
				{5512.467,134.800,10.000},
				{5525.445,129.778,10.000},
				{5537.926,124.807,10.000},
				{5549.914,119.885,10.000},
				{5561.415,115.012,10.000},
				{5572.434,110.184,10.000},
				{5582.974,105.402,10.000},
				{5593.040,100.664,10.000},
				{5602.637,95.968,10.000},
				{5611.768,91.313,10.000},
				{5620.438,86.696,10.000},
				{5628.650,82.118,10.000},
				{5636.407,77.575,10.000},
				{5643.714,73.067,10.000},
				{5650.573,68.592,10.000},
				{5656.988,64.148,10.000},
				{5662.961,59.733,10.000},
				{5668.496,55.346,10.000},
				{5673.594,50.985,10.000},
				{5678.259,46.648,10.000},
				{5682.493,42.334,10.000},
				{5686.297,38.039,10.000},
				{5689.673,33.764,10.000},
				{5692.623,29.505,10.000},
				{5695.165,25.412,10.000},
				{5697.328,21.631,10.000},
				{5699.144,18.161,10.000},
				{5700.644,14.998,10.000},
				{5701.858,12.141,10.000},
				{5702.816,9.587,10.000},
				{5703.550,7.337,10.000},
				{5704.089,5.388,10.000},
				{5704.463,3.740,10.000},
				{5704.702,2.392,10.000},
				{5704.837,1.345,10.000},
				{5704.896,0.597,10.000},
				{5704.911,0.149,10.000},
				{5704.911,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.015,0.300,10.000},
				{0.075,0.599,10.000},
				{0.210,1.348,10.000},
				{0.450,2.397,10.000},
				{0.824,3.746,10.000},
				{1.364,5.396,10.000},
				{2.098,7.346,10.000},
				{3.058,9.598,10.000},
				{4.274,12.153,10.000},
				{5.775,15.012,10.000},
				{7.592,18.176,10.000},
				{9.757,21.648,10.000},
				{12.300,25.430,10.000},
				{15.253,29.525,10.000},
				{18.631,33.784,10.000},
				{22.437,38.060,10.000},
				{26.673,42.355,10.000},
				{31.340,46.669,10.000},
				{36.440,51.006,10.000},
				{41.977,55.368,10.000},
				{47.953,59.755,10.000},
				{54.369,64.169,10.000},
				{61.231,68.614,10.000},
				{68.540,73.089,10.000},
				{76.299,77.597,10.000},
				{84.513,82.140,10.000},
				{93.185,86.719,10.000},
				{102.319,91.335,10.000},
				{111.918,95.991,10.000},
				{121.987,100.687,10.000},
				{132.529,105.426,10.000},
				{143.550,110.208,10.000},
				{155.054,115.035,10.000},
				{167.044,119.909,10.000},
				{179.528,124.831,10.000},
				{192.508,129.802,10.000},
				{205.990,134.824,10.000},
				{219.980,139.899,10.000},
				{234.483,145.027,10.000},
				{249.504,150.211,10.000},
				{265.049,155.451,10.000},
				{281.124,160.749,10.000},
				{297.735,166.107,10.000},
				{314.887,171.526,10.000},
				{332.588,177.008,10.000},
				{350.843,182.555,10.000},
				{369.660,188.167,10.000},
				{389.045,193.847,10.000},
				{409.004,199.596,10.000},
				{429.546,205.416,10.000},
				{450.677,211.309,10.000},
				{472.405,217.276,10.000},
				{494.736,223.318,10.000},
				{517.680,229.438,10.000},
				{541.244,235.635,10.000},
				{565.435,241.913,10.000},
				{590.262,248.271,10.000},
				{615.733,254.711,10.000},
				{641.857,261.234,10.000},
				{668.640,267.838,10.000},
				{696.093,274.525,10.000},
				{724.222,281.294,10.000},
				{753.037,288.144,10.000},
				{782.544,295.072,10.000},
				{812.752,302.077,10.000},
				{843.667,309.154,10.000},
				{875.297,316.299,10.000},
				{907.648,323.508,10.000},
				{940.725,330.772,10.000},
				{974.533,338.085,10.000},
				{1009.077,345.435,10.000},
				{1044.358,352.812,10.000},
				{1080.378,360.203,10.000},
				{1117.138,367.593,10.000},
				{1154.634,374.965,10.000},
				{1192.864,382.302,10.000},
				{1231.823,389.582,10.000},
				{1271.501,396.783,10.000},
				{1311.889,403.883,10.000},
				{1352.975,410.857,10.000},
				{1394.743,417.678,10.000},
				{1437.175,424.321,10.000},
				{1480.251,430.760,10.000},
				{1523.948,436.969,10.000},
				{1568.240,442.923,10.000},
				{1613.100,448.598,10.000},
				{1658.497,453.976,10.000},
				{1704.401,459.036,10.000},
				{1750.777,463.764,10.000},
				{1797.593,468.151,10.000},
				{1844.811,472.187,10.000},
				{1892.398,475.871,10.000},
				{1940.319,479.205,10.000},
				{1988.538,482.193,10.000},
				{2037.023,484.845,10.000},
				{2085.740,487.174,10.000},
				{2134.659,489.196,10.000},
				{2183.752,490.929,10.000},
				{2232.992,492.394,10.000},
				{2282.353,493.613,10.000},
				{2331.795,494.419,10.000},
				{2381.261,494.658,10.000},
				{2430.697,494.365,10.000},
				{2480.055,493.575,10.000},
				{2529.287,492.322,10.000},
				{2578.351,490.639,10.000},
				{2627.206,488.554,10.000},
				{2675.816,486.095,10.000},
				{2724.144,483.286,10.000},
				{2772.159,480.150,10.000},
				{2819.830,476.705,10.000},
				{2867.127,472.968,10.000},
				{2914.022,468.953,10.000},
				{2960.489,464.672,10.000},
				{3006.519,460.299,10.000},
				{3052.119,455.997,10.000},
				{3097.295,451.763,10.000},
				{3142.054,447.589,10.000},
				{3186.401,443.470,10.000},
				{3230.341,439.398,10.000},
				{3273.877,435.367,10.000},
				{3317.014,431.368,10.000},
				{3359.754,427.394,10.000},
				{3402.097,423.437,10.000},
				{3444.046,419.487,10.000},
				{3485.600,415.538,10.000},
				{3526.758,411.580,10.000},
				{3567.518,407.605,10.000},
				{3607.879,403.606,10.000},
				{3647.836,399.575,10.000},
				{3687.387,395.503,10.000},
				{3726.525,391.384,10.000},
				{3765.246,387.209,10.000},
				{3803.543,382.974,10.000},
				{3841.411,378.672,10.000},
				{3878.840,374.297,10.000},
				{3915.812,369.714,10.000},
				{3952.292,364.798,10.000},
				{3988.248,359.561,10.000},
				{4023.649,354.017,10.000},
				{4058.468,348.182,10.000},
				{4092.675,342.076,10.000},
				{4126.247,335.720,10.000},
				{4159.161,329.138,10.000},
				{4191.397,322.359,10.000},
				{4222.938,315.412,10.000},
				{4253.771,308.328,10.000},
				{4283.885,301.142,10.000},
				{4313.274,293.889,10.000},
				{4341.935,286.606,10.000},
				{4369.878,279.435,10.000},
				{4397.129,272.511,10.000},
				{4423.715,265.855,10.000},
				{4449.664,259.489,10.000},
				{4475.007,253.429,10.000},
				{4499.776,247.693,10.000},
				{4524.005,242.292,10.000},
				{4547.729,237.237,10.000},
				{4570.982,232.533,10.000},
				{4593.800,228.182,10.000},
				{4616.218,224.180,10.000},
				{4638.270,220.520,10.000},
				{4659.990,217.193,10.000},
				{4681.408,214.182,10.000},
				{4702.555,211.469,10.000},
				{4723.458,209.035,10.000},
				{4744.144,206.855,10.000},
				{4764.634,204.906,10.000},
				{4784.950,203.160,10.000},
				{4805.110,201.593,10.000},
				{4825.127,200.178,10.000},
				{4845.016,198.889,10.000},
				{4864.786,197.702,10.000},
				{4884.446,196.593,10.000},
				{4904.000,195.540,10.000},
				{4923.452,194.523,10.000},
				{4942.804,193.523,10.000},
				{4962.057,192.525,10.000},
				{4981.208,191.512,10.000},
				{5000.255,190.473,10.000},
				{5019.195,189.395,10.000},
				{5038.022,188.270,10.000},
				{5056.730,187.088,10.000},
				{5075.315,185.844,10.000},
				{5093.768,184.531,10.000},
				{5112.082,183.145,10.000},
				{5130.251,181.684,10.000},
				{5148.265,180.143,10.000},
				{5166.117,178.522,10.000},
				{5183.799,176.819,10.000},
				{5201.302,175.033,10.000},
				{5218.619,173.165,10.000},
				{5235.740,171.215,10.000},
				{5252.659,169.183,10.000},
				{5269.366,167.070,10.000},
				{5285.854,164.878,10.000},
				{5302.114,162.607,10.000},
				{5318.140,160.259,10.000},
				{5333.924,157.836,10.000},
				{5349.458,155.338,10.000},
				{5364.734,152.768,10.000},
				{5379.747,150.127,10.000},
				{5394.489,147.417,10.000},
				{5408.953,144.639,10.000},
				{5423.132,141.795,10.000},
				{5437.021,138.887,10.000},
				{5450.612,135.916,10.000},
				{5463.901,132.884,10.000},
				{5476.880,129.792,10.000},
				{5489.544,126.642,10.000},
				{5501.888,123.435,10.000},
				{5513.905,120.173,10.000},
				{5525.591,116.857,10.000},
				{5536.939,113.489,10.000},
				{5547.947,110.070,10.000},
				{5558.607,106.602,10.000},
				{5568.915,103.086,10.000},
				{5578.868,99.523,10.000},
				{5588.459,95.915,10.000},
				{5597.685,92.263,10.000},
				{5606.542,88.569,10.000},
				{5615.026,84.835,10.000},
				{5623.132,81.061,10.000},
				{5630.857,77.250,10.000},
				{5638.197,73.403,10.000},
				{5645.149,69.521,10.000},
				{5651.710,65.606,10.000},
				{5657.876,61.660,10.000},
				{5663.644,57.685,10.000},
				{5669.013,53.682,10.000},
				{5673.978,49.653,10.000},
				{5678.538,45.600,10.000},
				{5682.690,41.525,10.000},
				{5686.433,37.429,10.000},
				{5689.765,33.315,10.000},
				{5692.683,29.185,10.000},
				{5695.202,25.191,10.000},
				{5697.351,21.483,10.000},
				{5699.157,18.065,10.000},
				{5700.651,14.938,10.000},
				{5701.861,12.105,10.000},
				{5702.818,9.568,10.000},
				{5703.551,7.327,10.000},
				{5704.089,5.383,10.000},
				{5704.463,3.738,10.000},
				{5704.702,2.392,10.000},
				{5704.837,1.345,10.000},
				{5704.896,0.597,10.000},
				{5704.911,0.149,10.000},
				{5704.911,0.000,10.000}
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